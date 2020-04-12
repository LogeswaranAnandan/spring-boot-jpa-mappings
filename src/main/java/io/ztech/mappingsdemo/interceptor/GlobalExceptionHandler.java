package io.ztech.mappingsdemo.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.ztech.mappingsdemo.constants.ErrorConstants;
import io.ztech.mappingsdemo.exception.ApplicationException;
import io.ztech.mappingsdemo.models.ErrorObject;
import io.ztech.mappingsdemo.models.ResponseObject;

// Class that catches the Exceptions thrown from the controller, performs some action and then returns the response entity
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Handles the Application Exception thrown from the controller
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ResponseObject> applicationExceptionHandler(ApplicationException e) {
		// Create an error object using the error code, error message and error body from the exception
		ErrorObject errorObject = new ErrorObject(e.getErrorCode(), e.getErrorMessage(), e.getErrorBody());
		
		// Wrap the error response inside the response object
		ResponseObject responseObject = new ResponseObject(false, errorObject);
		
		// Return the response entity.
		return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
	}

	// Handles the Exception thrown from the controller
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseObject> genericExceptionHandler(Exception e) {
		// Create an error object using the generic error code and error message.
		ErrorObject errorObject = new ErrorObject(ErrorConstants.ERR_GENERIC_EXCEPTION,
				ErrorConstants.ERR_GENERIC_EXCEPTION_MESSAGE);
		
		// Wrap the error response inside the response object
		ResponseObject responseObject = new ResponseObject(false, errorObject);
		
		// Return the response entity.
		return new ResponseEntity<ResponseObject>(responseObject, HttpStatus.OK);
	}

}
