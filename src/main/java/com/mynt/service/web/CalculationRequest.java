package com.mynt.service.web;

import java.util.List;

import com.mynt.service.model.Rule;

public class CalculationRequest {
	
	private QuantityRequest weight;
	
	private QuantityRequest height;
	
	private QuantityRequest width;
	
	private QuantityRequest length;
	
	private Other other;

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

	public Other getOther() {
		return other;
	}

	public void setOther(Other other) {
		this.other = other;
	}
	
	public class Other {
		private String voucherCode;
		
		private List<Rule> rules;

		public String getVoucherCode() {
			return voucherCode;
		}

		public void setVoucherCode(String voucherCode) {
			this.voucherCode = voucherCode;
		}

		public List<Rule> getRules() {
			return rules;
		}

		public void setRules(List<Rule> rules) {
			this.rules = rules;
		}
	}
}
