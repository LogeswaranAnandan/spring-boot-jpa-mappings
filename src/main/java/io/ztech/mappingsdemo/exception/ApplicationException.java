package io.ztech.mappingsdemo.exception;

public class ApplicationException extends Exception {

	private String errorCode;
	private String errorMessage;
	private Object errorBody;

	//	Default Constructor
	public ApplicationException() {
	}

	//	Constructor to set errorcode and errormessage
	public ApplicationException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	//	Constructor to set errorCode, errorMessage and errorBody.
	public ApplicationException(String errorCode, String errorMessage, Object errorBody) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorBody = errorBody;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getErrorBody() {
		return errorBody;
	}

}
