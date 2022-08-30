package com.pkg.code.mutant.execption;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter @Setter
public class HandledException extends RuntimeException {


	private static final long serialVersionUID = -1701103574391064913L;

	private String code;
	private HttpStatus statusCode;
	private String message;
	private String erroMessage;
	private Object[] argsMessage;

	public HandledException(String error, HttpStatus status) {
		super(error);
		this.message = error;
		this.statusCode = status;
	}

	public HandledException(String error, HttpStatus status, String errorMessage) {
		super(error);
		this.code = error;
		this.statusCode = status;
		this.erroMessage = errorMessage;
	}

}
