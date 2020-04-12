package io.ztech.mappingsdemo.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import io.ztech.mappingsdemo.annotation.IgnoreResponseWrapper;
import io.ztech.mappingsdemo.models.ResponseObject;

// Class that intercepts the response returned from controller and wraps it inside our custom response format
@ControllerAdvice
public class ResponseBodyWrapper implements ResponseBodyAdvice<Object> {

	// Method that determines whether beforeBodyWrite has to be executed for the
	// response returned from the controller.
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// Check if the class returning the response is annotated with @RestController
		if (returnType.getContainingClass().isAnnotationPresent(RestController.class)) {
			// Check if the method returning the response is NOT annotated with @IgnoreResponseWrapper
			// @IgnoreResponseWrapper is a custom annotation utility defined to avoid wrapping of the response.
			if (!returnType.getMethod().isAnnotationPresent(IgnoreResponseWrapper.class)) {
				return true;
			}
		}
		return false;
	}

	// Method used to wrap the response if the supports method returns true for a given response.
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		// Wraps the body returned from controller to the required format
		ResponseObject responseObject = new ResponseObject(true, body);
		
		// Return the wrapped response
		return responseObject;
	}

}
