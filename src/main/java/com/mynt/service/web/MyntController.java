package com.mynt.service.web;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mynt.service.process.MyntService;
import com.mynt.service.process.MyntServiceResponse;

@RestController
@RequestMapping(path = {"/api/mynt"})
public class MyntController {
	
	private static final Log LOG = LogFactory.getLog(MyntController.class); 
	
	@Autowired
	private MyntService myntService;
	
	@PostMapping
	public ResponseEntity<MyntResponseWrapper> calculate(@RequestBody CalculationRequest body){
		MyntResponseWrapper response = new MyntResponseWrapper();
		MyntServiceResponse serviceResponse = new MyntServiceResponse();
		try {
			serviceResponse = myntService.calculate(body);
			response.setData(serviceResponse);
		} catch(Exception ex) {
			LOG.error(ex.getMessage());
			serviceResponse.setMessage("Bad Request.");
			response.setData(serviceResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/default")
	public ResponseEntity<MyntResponseWrapper> calculate(@RequestParam("voucherCode") String voucherCode, @RequestBody DefaultRequest request){
		MyntResponseWrapper response = new MyntResponseWrapper();
		MyntServiceResponse serviceResponse = new MyntServiceResponse();
		try {
			CalculationRequest body = new CalculationRequest();
			body.setWeight(new QuantityRequest("kg", request.getWeight()));
			body.setHeight(new QuantityRequest("cm", request.getHeight()));
			body.setWidth(new QuantityRequest("cm", request.getWidth()));
			body.setLength(new QuantityRequest("cm", request.getLength()));
			
			CalculationRequest.Other other = body.new Other();
			other.setVoucherCode(voucherCode);
			body.setOther(other);
			
			serviceResponse = myntService.calculate(body);
			response.setData(serviceResponse);
		} catch(Exception ex) {
			LOG.error(ex.getMessage());
			serviceResponse.setMessage("Bad Request.");
			response.setData(serviceResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
