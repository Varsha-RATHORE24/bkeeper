package com.info.company.exception;

public class InvalidHeaderFileException extends RuntimeException{

private static final long serialVersionULD=1L;
private String message;


public InvalidHeaderFileException(String message) {

	this.setMessage(message);
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
