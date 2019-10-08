package com.mynt.service.web;

import java.util.Map;

public class CalculationRequest {
	
	private QuantityRequest weight;
	
	private QuantityRequest height;
	
	private QuantityRequest width;
	
	private QuantityRequest length;
	
	private Map<String, Object> other;

	public QuantityRequest getWeight() {
		return weight;
	}

	public void setWeight(QuantityRequest weight) {
		this.weight = weight;
	}

	public QuantityRequest getHeight() {
		return height;
	}

	public void setHeight(QuantityRequest height) {
		this.height = height;
	}

	public QuantityRequest getWidth() {
		return width;
	}

	public void setWidth(QuantityRequest width) {
		this.width = width;
	}

	public QuantityRequest getLength() {
		return length;
	}

	public void setLength(QuantityRequest length) {
		this.length = length;
	}

	public Map<String, Object> getOther() {
		return other;
	}

	public void setOther(Map<String, Object> other) {
		this.other = other;
	}
}
