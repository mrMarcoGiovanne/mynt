package com.mynt.service.web;

import java.math.BigDecimal;

public class QuantityRequest {
	
	private String unit;
	
	private BigDecimal value;
	
	public QuantityRequest() {}

	public QuantityRequest(String unit, BigDecimal value) {
		super();
		this.unit = unit;
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
