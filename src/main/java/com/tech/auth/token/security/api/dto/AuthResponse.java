package com.tech.auth.token.security.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
	
	@JsonProperty("hash")
	private String hash;
	
	@JsonProperty("match")
	private boolean match;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

}
