package com.mynt.service.process;

import java.util.ArrayList;
import java.util.List;

public class MyntServiceResponse {
	private Object result;
	
	private String message;
	
	private List<String> errors = new ArrayList<>();

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
}
