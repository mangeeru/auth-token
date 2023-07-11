package com.tech.auth.token.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.auth.token.security.api.dto.AuthRequest;
import com.tech.auth.token.security.api.dto.AuthResponse;
import com.tech.auth.token.security.api.dto.RequestResponseWrapper;
import com.tech.auth.token.security.service.HashService;

@RestController
public class HashController {
	
	@Autowired
	private HashService hashService;
	
	@PostMapping(value = "/generate-hash", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestResponseWrapper<AuthResponse>> generateHash(@RequestBody RequestResponseWrapper<AuthRequest> request){
		AuthResponse response = null;
		if(request.getData() != null) {
			response = hashService.generateHash(request.getData());
		}
		RequestResponseWrapper responseWrapper = new RequestResponseWrapper<>();
		responseWrapper.setData(response);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}
	
	@PostMapping(value = "/verify-hash", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestResponseWrapper<AuthResponse>> verifyHash(@RequestBody RequestResponseWrapper<AuthRequest> request){
		RequestResponseWrapper response = new RequestResponseWrapper<>();
		if(request.getData() != null) {
			response.setData(hashService.verifyHash(request.getData()));
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(value = "/verify-hash-array", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RequestResponseWrapper<AuthResponse>> verifyHashArray(@RequestBody RequestResponseWrapper<AuthRequest> request){
		RequestResponseWrapper response = new RequestResponseWrapper<>();
		if(request.getData() != null) {
			response.setData(hashService.verifyHash(request.getData()));
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value = "health-check")
	public String healthCheck() {
		return "Application up and running...!";
	}

}
