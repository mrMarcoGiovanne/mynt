package com.mynt.service.web;

import java.util.Map;

import com.mynt.service.model.BaseParcelProperty;

public class MyntRequest {
	
	private BaseParcelProperty data;
	
	private Map<String, Object> other;

	public BaseParcelProperty getData() {
		return data;
	}

	public void setData(BaseParcelProperty data) {
		this.data = data;
	}

	public Map<String, Object> getOther() {
		return other;
	}

	public void setOther(Map<String, Object> other) {
		this.other = other;
	}
}
