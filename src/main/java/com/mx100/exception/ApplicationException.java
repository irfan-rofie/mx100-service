package com.mx100.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplicationException() {		
	}
	
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    public ApplicationException(String message) {
    	super(message);
    }
    public ApplicationException(String message,Throwable cause) {
    	super(message,cause);
    }

}
