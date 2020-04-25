package io.ztech.mappingsdemo.exception;

import io.ztech.mappingsdemo.constants.ErrorConstants;

public class ApplicationException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	
	private String errorCode;
	private String errorMessage;
	private Object errorBody;

	//	Default Constructor
	public ApplicationException() {
		this.errorCode = ErrorConstants.ERR_GENERIC_EXCEPTION;
		this.errorMessage = ErrorConstants.ERR_GENERIC_EXCEPTION_MESSAGE;
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
