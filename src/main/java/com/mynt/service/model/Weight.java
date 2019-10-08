package com.mynt.service.model;

import java.math.BigDecimal;

public class Weight {
	
	
	public enum Measurement {
		KG;
	}
	
	private Measurement measurement;
	
	private BigDecimal value;

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
