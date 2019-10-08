package com.mynt.service.model;

import java.util.ArrayList;
import java.util.List;

import com.mynt.service.model.Dimension.Type;

public class BaseParcelProperty {
	
	private Dimension height;
	
	private Dimension width;
	
	private Dimension length;
	
	private Weight weight;
	
	private List<Rule> rules = new ArrayList<>();

	public Dimension getHeight() {
		return height;
	}

	public void setHeight(Dimension height) {
		this.height = height;
		this.height.setDimensionType(Type.HEIGHT);
	}

	public Dimension getWidth() {
		return width;
	}

	public void setWidth(Dimension width) {
		this.width = width;
	}

	public Dimension getLength() {
		return length;
	}

	public void setLength(Dimension length) {
		this.length = length;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
}
