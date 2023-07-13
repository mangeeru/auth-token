package com.tech.auth.token.jmt.dto;

public class TokenResponse {
	
	private String userId;
	
	private String token;
	
	private boolean isValid;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenResponse [userId=");
		builder.append(userId);
		builder.append(", token=");
		builder.append(token);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}

}
