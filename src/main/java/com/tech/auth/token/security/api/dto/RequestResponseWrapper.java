package com.tech.auth.token.security.api.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResponseWrapper<T> {
	
	@JsonProperty("data")
	private T data;
	
	@JsonProperty("meta")
	private Map<String, Object> meta = new HashMap<>();
	
	@JsonProperty("error_code")
	private String errorCode;
	
	@JsonProperty("error_message")
	private String errorMessage;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
