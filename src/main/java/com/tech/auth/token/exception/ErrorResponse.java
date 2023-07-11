package com.tech.auth.token.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
@JsonInclude(content = Include.NON_NULL)
public class ErrorResponse {
	
	@JsonProperty("Code")
	private String code=null;
	
	@JsonProperty("Id")
	private String id = null;
	
	@JsonProperty("Message")
	private String message = null;
	
	@JsonProperty("Error")
	private List<ErrorDetails> errors = new ArrayList<>();
	
	public ErrorResponse code(String code) {
		this.code = code;
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorDetails> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetails> errors) {
		this.errors = errors;
	}

}
