package com.mynt.service.validator;

import java.util.List;

public class ValidationResult {
	
	private String errorMessage;
	
	private List<String> errorMessages;
	
	private Boolean valid;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Boolean isValid() {
		return valid;
	}

	public void isValid(Boolean valid) {
		this.valid = valid;
	}
}
