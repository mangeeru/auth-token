package com.tech.auth.token.jmt.dto;

public class TokenRequest {
	
	private String userId;
	
	private String appId;
	
	private String entity;

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

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenRequest [userId=");
		builder.append(userId);
		builder.append(", appId=");
		builder.append(appId);
		builder.append(", entity=");
		builder.append(entity);
		builder.append("]");
		return builder.toString();
	}

}
