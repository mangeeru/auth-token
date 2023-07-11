package com.tech.auth.token.security.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest {
	
	@JsonProperty("secret")
	private String secret;
	
	@JsonProperty("hash")
	private String hash;
	
	@JsonProperty("hashArray")
	private String[] hashArray;
	
	@JsonProperty("userId")
	private String userId;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String[] getHashArray() {
		return hashArray;
	}

	public void setHashArray(String[] hashArray) {
		this.hashArray = hashArray;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
