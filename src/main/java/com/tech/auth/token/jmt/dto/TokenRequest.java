package com.tech.auth.token.jmt.dto;

public class TokenRequest {
	
	private String userId;
	
	private String appId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenRequest [userId=");
		builder.append(userId);
		builder.append(", appId=");
		builder.append(appId);
		builder.append("]");
		return builder.toString();
	}

}
