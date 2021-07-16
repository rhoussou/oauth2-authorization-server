package org.cyrol.auth.exception;


public class BadRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessage;

    private int errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

    public BadRequestException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BadRequestException() {
        super();
    }

    public BadRequestException(String errorMessage, int errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.setErrorCode(errorCode);
    }

	
}

