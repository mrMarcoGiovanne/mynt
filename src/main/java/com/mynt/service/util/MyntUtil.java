package com.mynt.service.util;

import java.util.Map;

import com.mynt.service.model.BaseParcelProperty;
import com.mynt.service.model.Dimension;
import com.mynt.service.model.Dimension.Type;

public class MyntUtil {
	
	
	public static BaseParcelProperty mapToBaseParcelProperty(Map<String, Object> data) {
		BaseParcelProperty object = new BaseParcelProperty();
		
		Dimension height = new Dimension(Type.HEIGHT);
		
		data.get("height");
		object.setHeight(height);
		
		return object;
	}
	
}
