package io.ztech.mappingsdemo.models;


public class ResponseObject {

	private boolean isSuccess;
	private Object responseBody;
	
	public ResponseObject() {}
	
	public ResponseObject(boolean isSuccess, Object responseBody) {
		this.isSuccess = isSuccess;
		this.responseBody = responseBody;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	@Override
	public String toString() {
		return "ResponseObject [isSuccess=" + isSuccess + ", responseBody=" + responseBody + "]";
	}

}
