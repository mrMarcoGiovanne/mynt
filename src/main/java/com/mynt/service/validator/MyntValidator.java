package com.mynt.service.validator;

import com.mynt.service.web.CalculationRequest;

public interface MyntValidator {
	ValidationResult validateRequest(CalculationRequest request);
}
