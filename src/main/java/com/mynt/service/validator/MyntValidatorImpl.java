package com.mynt.service.validator;

import org.springframework.stereotype.Component;

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

	@Override
	public ValidationResult validateRequest(CalculationRequest request) {
		ValidationResult result = new ValidationResult();
		
		doCheckWeight(request, result);
		
		doCheckDimensionHeight(request, result);
		
		doCheckDimensionWidth(request, result);
		
		doCheckDimensionLength(request, result);
		
		return result;
	}

	private void doCheckWeight(CalculationRequest request, ValidationResult result) {
		QuantityRequest weight = request.getWeight();
		boolean isWeightUnitExist = false;
		for(WeightUnit weightUnit : WeightUnit.values()) {
			if (weightUnit.name().equalsIgnoreCase(weight.getUnit())) {
				isWeightUnitExist = true;
			}
			
		}
		
		if(!isWeightUnitExist) {
			result.getErrorMessages().add("Weight unit = " + weight.getUnit() + " is not yet available.");
		}
	}
	
	private void doCheckDimensionHeight(CalculationRequest request, ValidationResult result) {
		QuantityRequest height = request.getHeight();
		boolean isHeightUnitExist = false;
		for(WeightUnit weightUnit : WeightUnit.values()) {
			if (weightUnit.name().equalsIgnoreCase(height.getUnit())) {
				isHeightUnitExist = true;
			}
			
		}
		
		if(!isHeightUnitExist) {
			result.getErrorMessages().add("Height unit = " + height.getUnit() + " is not yet available.");
		}
	}
	
	private void doCheckDimensionWidth(CalculationRequest request, ValidationResult result) {
		QuantityRequest width = request.getWidth();
		boolean isWidthUnitExist = false;
		for(WeightUnit weightUnit : WeightUnit.values()) {
			if (weightUnit.name().equalsIgnoreCase(width.getUnit())) {
				isWidthUnitExist = true;
			}
			
		}
		
		if(!isWidthUnitExist) {
			result.getErrorMessages().add("Width unit = " + width.getUnit() + " is not yet available.");
		}
	}
	
	private void doCheckDimensionLength(CalculationRequest request, ValidationResult result) {
		QuantityRequest lenght = request.getLength();
		boolean isLengthUnitExist = false;
		for(WeightUnit weightUnit : WeightUnit.values()) {
			if (weightUnit.name().equalsIgnoreCase(lenght.getUnit())) {
				isLengthUnitExist = true;
			}
			
		}
		
		if(!isLengthUnitExist) {
			result.getErrorMessages().add("Lenght unit = " + lenght.getUnit() + " is not yet available.");
		}
	}

}
