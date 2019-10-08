package com.mynt.service.process;

import com.mynt.service.web.CalculationRequest;

public interface MyntService {
	MyntServiceResponse calculate(CalculationRequest baseParcelProperty);
}
