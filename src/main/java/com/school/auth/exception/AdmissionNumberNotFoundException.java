package com.school.auth.exception;

@SuppressWarnings("serial")
public class AdmissionNumberNotFoundException extends RuntimeException{
	
	public AdmissionNumberNotFoundException(Throwable t) {
		super(t);
	}

	public AdmissionNumberNotFoundException(String msg) {
		super(msg);
	}


}
