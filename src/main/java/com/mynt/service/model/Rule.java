package com.mynt.service.model;

import java.math.BigDecimal;

public class Rule {
	
	private Integer priority;
	
	private BigDecimal cost;
	
	private Quantity quantity;
	
	private BigDecimal conditionLimit;

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConditionLimit() {
		return conditionLimit;
	}

	public void setConditionLimit(BigDecimal conditionLimit) {
		this.conditionLimit = conditionLimit;
	}
}
