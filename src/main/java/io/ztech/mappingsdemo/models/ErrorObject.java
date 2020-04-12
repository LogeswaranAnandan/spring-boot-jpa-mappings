package io.ztech.mappingsdemo.models;

public class ErrorObject {

	private String errorCode;
	private String errorMessage;
	private Object errorBody;
	
//	Default Constructor
	public ErrorObject() {
	}

	//	Constructor to set errorcode and errormessage
	public ErrorObject(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	//	Constructor to set errorCode, errorMessage and errorBody.
	public ErrorObject(String errorCode, String errorMessage, Object errorBody) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorBody = errorBody;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getErrorBody() {
		return errorBody;
	}

	public void setErrorBody(Object errorBody) {
		this.errorBody = errorBody;
	}

	@Override
	public String toString() {
		return "ErrorObject [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorBody=" + errorBody
				+ "]";
	}

}
