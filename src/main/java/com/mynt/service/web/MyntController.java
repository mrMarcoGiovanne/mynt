package com.mynt.service.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynt.service.process.MyntService;

@RestController
@RequestMapping(path = {"/api/mynt"})
public class MyntController {
	
	@Autowired
	private MyntService myntService;
	
	@PostMapping
	public ResponseEntity<MyntResponseWrapper> calculate(CalculationRequest body){
		MyntResponseWrapper response = new MyntResponseWrapper();
		try {
			myntService.calculate(body);
		} catch(Exception ex) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
