package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidUsernameException extends Exception {
	
	public InvalidUsernameException(String message) {
		super(message);
	}
}
