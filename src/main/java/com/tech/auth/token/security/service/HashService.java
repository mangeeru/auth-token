package com.tech.auth.token.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.tech.auth.token.security.api.dto.AuthRequest;
import com.tech.auth.token.security.api.dto.AuthResponse;
import com.tech.auth.token.security.util.PasswordHashUtil;

@Configuration
@Service("hashService")
public class HashService {
	
	private static final Logger _logger = LoggerFactory.getLogger(HashService.class);
	
	@Value("${aes.password}")
	private String aesPassword;
	
	@Value("${aes.salt}")
	private CharSequence aesSalt;
	
	public PasswordHashUtil getHashUtil() {
		return new PasswordHashUtil(aesPassword, aesSalt);
	}
	
	public AuthResponse generateHash(AuthRequest request) {
		String hash="";
		_logger.info("Received request from controoler to service for Hash Generate");
		if(request.getSecret() != null && !request.getSecret().isEmpty()) {
			hash = getHashUtil().generateHash(request.getSecret());
		}
		_logger.info("Received Hash from HashUtil");
		AuthResponse response = new AuthResponse();
		response.setHash(hash);
		return response;
	}
	
	public AuthResponse verifyHash(AuthRequest request) {
		AuthResponse response = new AuthResponse();
		boolean isMatch = false;
		if(null != request.getHashArray() && request.getHashArray().length != 0) {
			isMatch = getHashUtil().verifyHash(request.getSecret(), request.getHashArray());
		} else {
			isMatch = getHashUtil().verifyHash(request.getSecret(), request.getHash());
		}
		response.setMatch(isMatch);
		return response;
	}

}
