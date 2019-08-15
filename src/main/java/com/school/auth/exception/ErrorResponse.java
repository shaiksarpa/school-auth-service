package com.school.auth.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	
	private Date date;
	
	private String message;
	
	private String details;
	
	
}
