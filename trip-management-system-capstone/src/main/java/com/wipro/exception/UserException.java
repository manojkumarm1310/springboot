package com.wipro.exception;

public class UserException extends Exception{
	public UserException() {
		super("User Exception");
	}
	public UserException(String message) {
		super(message);
	}
	public UserException(String message,Throwable t) {
		super(message,t);
	}
}
