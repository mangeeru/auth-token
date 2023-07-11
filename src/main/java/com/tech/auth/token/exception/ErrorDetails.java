package com.tech.auth.token.exception;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class ErrorDetails {
	
	@JsonProperty("ErrorCode")
	private ErrorKeyEnum errorCode = null;
	
	@JsonProperty("Message")
	private String message = null;
	
	@JsonProperty("Path")
	private String path = null;
	
	@JsonProperty("Url")
	private String url = null;
	
	public ErrorDetails errorCode(ErrorKeyEnum errorcode) {
		this.errorCode = errorcode;
		return this;
	}
	
	public ErrorDetails message(String message) {
		this.message = message;
		return this;
	}

	public ErrorKeyEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorKeyEnum errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
