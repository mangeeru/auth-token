package com.tech.auth.token.jmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.auth.token.dto.RequestResponseWrapper;
import com.tech.auth.token.jmt.dto.TokenRequest;
import com.tech.auth.token.jmt.dto.TokenResponse;
import com.tech.auth.token.jmt.dto.ValidateJmToken;
import com.tech.auth.token.jmt.service.JmTokenService;

@RestController
public class JmTokenController {
	
	@Autowired
	private JmTokenService jmTokenService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/get-token", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestResponseWrapper<TokenResponse>> getJmToken(@RequestBody RequestResponseWrapper<TokenRequest> request){
		TokenResponse response = null;
		if(request.getData() != null) {
			response = jmTokenService.generateToken(request.getData());
		}
		RequestResponseWrapper responseWrapper = new RequestResponseWrapper<>();
		responseWrapper.setData(response);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/verify-token", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestResponseWrapper<TokenResponse>> verifyToken(@RequestBody RequestResponseWrapper<ValidateJmToken> request){
		TokenResponse response = null;
		if(request.getData() != null) {
			response = jmTokenService.validateToken(request.getData());
		}
		RequestResponseWrapper responseWrapper = new RequestResponseWrapper<>();
		responseWrapper.setData(response);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}

}
