package com.mynt.service.model;

import java.math.BigDecimal;

public class ParcelCost {
	private BigDecimal cost;
	
	private BigDecimal discount;
	
	private BigDecimal total;
	
	public ParcelCost() {}

	public ParcelCost(BigDecimal cost, BigDecimal discount, BigDecimal total) {
		this.cost = cost;
		this.discount = discount;
		this.total = total;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
