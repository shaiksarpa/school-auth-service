package com.school.auth.exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	
	public ApplicationException(Throwable t) {
		super(t);
	}

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(String msg, Throwable t) {
		super(msg, t);
	}

}
