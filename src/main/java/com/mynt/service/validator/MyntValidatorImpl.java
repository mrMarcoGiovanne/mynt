package com.mynt.service.validator;

import org.springframework.stereotype.Component;

import com.mynt.service.model.Dimension;
import com.mynt.service.model.DimensionUnit;
import com.mynt.service.model.WeightUnit;
import com.mynt.service.web.CalculationRequest;
import com.mynt.service.web.QuantityRequest;

/**
 * 
 * @author Marco Giovanne
 *
 */
@Component
public class MyntValidatorImpl implements MyntValidator {
	
	private static final String INVALID_UNIT = " is invalid unit.";
	
	private static final String IS_NULL = "is null or unit is null.";

	@Override
	public ValidationResult validateRequest(CalculationRequest request) {
		ValidationResult result = new ValidationResult();
		
		doCheckWeight(request, result);
		
		doCheckDimension(Dimension.Type.HEIGHT, request.getHeight(), result);
		
		doCheckDimension(Dimension.Type.WIDTH, request.getWidth(), result);
		
		doCheckDimension(Dimension.Type.LENGTH, request.getLength(), result);
		
		if(result.getErrorMessages().size() > 0) {
			result.isValid(false);
		}
		
		return result;
	}
	

	private void doCheckWeight(CalculationRequest request, ValidationResult result) {
		
		if(request.getWeight() == null || request.getWeight().getUnit() == null) {
			result.getErrorMessages().add("Weight " + IS_NULL);
			return;
		}	

		QuantityRequest weight = request.getWeight();
		
		boolean isWeightUnitExist = false;
		for(WeightUnit weightUnit : WeightUnit.values()) {
			if (weightUnit.name().equalsIgnoreCase(weight.getUnit())) {
				isWeightUnitExist = true;
			}
			
		}
		
		if(!isWeightUnitExist) {
			result.getErrorMessages().add("Weight unit = " + weight.getUnit() + INVALID_UNIT);
		}
	}
	
	private void doCheckDimension(Dimension.Type type, QuantityRequest request, ValidationResult result) {
		
		if(request == null || request.getUnit() == null) {
			result.getErrorMessages().add(type.name() + " " + IS_NULL);
			return;
		}	
		
		boolean isHeightUnitExist = false;
		for(DimensionUnit dimensionUnit : DimensionUnit.values()) {
			if (dimensionUnit.name().equalsIgnoreCase(request.getUnit())) {
				isHeightUnitExist = true;
			}			
		}
		
		if(!isHeightUnitExist) {
			result.getErrorMessages().add(type.name() + " unit = " + request.getUnit() + INVALID_UNIT);
		}
	}


}
