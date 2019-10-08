package com.mynt.service.process;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mynt.service.model.ParcelCost;
import com.mynt.service.model.Quantity;
import com.mynt.service.model.Rule;
import com.mynt.service.model.Voucher;
import com.mynt.service.validator.MyntValidator;
import com.mynt.service.validator.ValidationResult;
import com.mynt.service.web.CalculationRequest;
import com.mynt.service.web.QuantityRequest;

@Service
public class MyntServiceImpl implements MyntService {
	
	private static final String REJECT = "Reject";
	
	private static final String HEAVY_PARCEL = "Heavy Parcel";
	
	private static final String SMALL_PARCEL = "Small Parcel";
	
	private static final String MEDIUM_PARCEL = "Medium Parcel";
	
	private static final String LARGE_PARCEL = "Large Parcel";
	
	@Value("${voucher.endpoint}")
	private String uri;

	@Autowired
	private MyntValidator myntValidator;

	@Override
	public MyntServiceResponse calculate(CalculationRequest request) {
		MyntServiceResponse result = new MyntServiceResponse();

		// Request validation
		ValidationResult validationResult = myntValidator.validateRequest(request);
		
		if (!validationResult.isValid()) {
			result.setMessage("Invalid Request.");
			result.getErrors().addAll(validationResult.getErrorMessages());
			return result;
		}
		
		return computeParcelCost(request);
		
	}
	

	private MyntServiceResponse computeParcelCost(CalculationRequest request) {
		MyntServiceResponse result = new MyntServiceResponse();
		List<Rule> rules = getRules(request);
		
		// Rule Checking
		QuantityRequest weightReq = request.getWeight();
		
		Rule weightRule = rules.get(0);
		
		
		if(weightReq.getValue().compareTo(weightRule.getConditionLimit()) > 0) {
			result.setMessage(REJECT);
			return result;
		}
		
		Rule heavyRule = rules.get(1);
		if(weightReq.getValue().compareTo(heavyRule.getConditionLimit()) > 0) {
			BigDecimal product = heavyRule.getCost().multiply(weightReq.getValue());
			applyDiscount(product, result, request);
			result.setMessage(HEAVY_PARCEL);
			return result;
		}
		
		BigDecimal volume = getVolume(request);
		
		Rule smallParcelRule = rules.get(2);
		if (volume.compareTo(smallParcelRule.getConditionLimit()) < 0) {
			BigDecimal product = smallParcelRule.getCost().multiply(volume);
			applyDiscount(product, result, request);
			result.setMessage(SMALL_PARCEL);
			return result;
		}
		
		Rule mediumParcelRule = rules.get(3);
		if(volume.compareTo(mediumParcelRule.getConditionLimit()) < 0) {
			BigDecimal product = mediumParcelRule.getCost().multiply(volume);
			applyDiscount(product, result, request);
			result.setMessage(MEDIUM_PARCEL);
			return result;
		} else {
			Rule largeParcelRule = rules.get(4);
			BigDecimal product = largeParcelRule.getCost().multiply(volume);
			
			if (largeParcelRule.getConditionLimit().equals(BigDecimal.ZERO)) {
				applyDiscount(product, result, request);
				result.setMessage(LARGE_PARCEL);
			} else {
				// this condition will be meet if large parcel rule condition limit has a value greater than zero
				if(volume.compareTo(largeParcelRule.getConditionLimit()) < 0) {
					applyDiscount(product, result, request);
					result.setMessage(LARGE_PARCEL);
				}
			}	
		}
		return result;
	}


	private BigDecimal getVolume(CalculationRequest request) {
		BigDecimal height = request.getHeight().getValue();

		BigDecimal width = request.getWidth().getValue();

		BigDecimal length = request.getLength().getValue();

		return height.multiply(width).multiply(length);
	}
	
	private List<Rule> getRules(CalculationRequest request) {
		List<Rule> rule = request.getOther().getRules();
		
		if(rule == null) {
			rule = defaultRules();
		}
		
		return rule;
	}
	

	private List<Rule> defaultRules() {
		List<Rule> rules = new ArrayList<>();
		rules.add(new Rule(1, BigDecimal.ZERO, Quantity.WEIGHT, new BigDecimal("50")));
		rules.add(new Rule(2, new BigDecimal("20"), Quantity.WEIGHT, new BigDecimal("10")));
		rules.add(new Rule(3, new BigDecimal("0.03"), Quantity.VOLUME, new BigDecimal("1500")));
		rules.add(new Rule(4, new BigDecimal("0.04"), Quantity.VOLUME, new BigDecimal("2500")));
		rules.add(new Rule(5, new BigDecimal("0.05"), Quantity.VOLUME, BigDecimal.ZERO));		
		return rules;
	}
	
	private void applyDiscount(BigDecimal product, MyntServiceResponse result, CalculationRequest request) {		String voucherCode = request.getOther().getVoucherCode();
		
		ParcelCost parcelCost = new ParcelCost();
		
		parcelCost.setCost(product);
		parcelCost.setDiscount(BigDecimal.ZERO);
		parcelCost.setTotal(product);
		result.setResult(parcelCost);
		
		if(voucherCode != null) {
			RestTemplate restTemplate = new RestTemplate();
			
			Map<String, String> params = new HashMap<>();
		    params.put("voucherCode", voucherCode);
		    params.put("apikey", "apikey");
			
		    // TODO handle 404 and bad request
		    Voucher response = restTemplate.getForObject(uri + "/{voucherCode}?key={apikey}", Voucher.class, params);
			
		    LocalDate localDate = LocalDate.now();
		    
			BigDecimal discount = new BigDecimal(response.getDiscount());
			
			parcelCost.setDiscount(discount);
			if(localDate.compareTo(response.getExpiry()) <= 0) {
				if(product.compareTo(discount) >= 1 ) {
					parcelCost.setTotal(product.subtract(discount));
					result.setResult(parcelCost);
				} else {
					// discount is greater than product ?
					parcelCost.setTotal(BigDecimal.ZERO);
					result.setResult(parcelCost);
				}
			}
			
		}
		
	}

}
