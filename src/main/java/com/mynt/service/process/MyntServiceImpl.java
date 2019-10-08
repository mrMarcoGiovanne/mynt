package com.mynt.service.process;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynt.service.validator.MyntValidator;
import com.mynt.service.web.CalculationRequest;

@Service
public class MyntServiceImpl implements MyntService {
	
	@Autowired
	private MyntValidator myntValidator;

	@Override
	public MyntServiceResponse calculate(CalculationRequest request) {
		MyntServiceResponse result = new MyntServiceResponse();
		
		// validation
		myntValidator.validateRequest(request);
		
		
		
		BigDecimal height = request.getHeight().getValue();
		
		BigDecimal width = request.getWidth().getValue();
		
		BigDecimal length = request.getLength().getValue();
		
		BigDecimal volume = height.multiply(width).multiply(length);
		
		
		
		return result;
	}

}
