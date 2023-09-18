package com.tech.auth.token.exception;

public class UserNotMatchException extends Exception{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotMatchException() {
		super();
	}
	
	public UserNotMatchException(String message) {
		super(message);
	}
}
