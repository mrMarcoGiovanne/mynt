package com.mynt.service.model;

import java.math.BigDecimal;

public class Dimension {
	
	public enum Type {
		HEIGHT, WEIGHT, LENGTH;
	}
	
	/**
	 *  Should be separated enum since this is not specifically for Dimension only
	 */
	public enum MeasurementType {
		CM; // add other type of measurement
	}
	
	private Type dimensionType;
	
	private MeasurementType measurementType;
	
	private BigDecimal value;
	
	public Dimension() { }
	
	public Dimension(Type dimensionType) {
		this.dimensionType = dimensionType;
	}

	public Dimension(Type dimensionType, MeasurementType measurementType, BigDecimal value) {
		super();
		this.dimensionType = dimensionType;
		this.measurementType = measurementType;
		this.value = value;
	}

	public Type getDimensionType() {
		return dimensionType;
	}
	
	public void setDimensionType(Type dimensionType) {
		this.dimensionType = dimensionType;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
