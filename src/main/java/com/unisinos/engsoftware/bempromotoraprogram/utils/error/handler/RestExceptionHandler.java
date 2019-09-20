package com.unisinos.engsoftware.bempromotoraprogram.utils.error.handler;

import java.util.Date;

import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.BusinessException;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionCode;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionsDetails;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	private Messages messages;

	@Autowired
	public RestExceptionHandler(Messages messages) {
		this.messages = messages;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
		ExceptionsDetails rfnDetails = new ExceptionsDetails(messages.get("exception.resource.notfound"),
				ExceptionCode.ERROR_RESOURCE_NOT_FOUND.toString(), rfnException.getMessage(), new Date().getTime(),
				rfnException.getClass().getSimpleName());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Error", rfnException.getMessage());
		headers.add("Message", rfnDetails.getDetail());
		return new ResponseEntity<>(rfnDetails, headers, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException busException) {
		ExceptionsDetails busDetails = new ExceptionsDetails(messages.get("exception.bussiness.generic"),
				busException.getExceptionCode().toString(), busException.getMessage(), new Date().getTime(),
				busException.getClass().getSimpleName());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Error", busDetails.getMessage());
		headers.add("Message", busDetails.getDetail());
		return new ResponseEntity<>(busDetails, headers, HttpStatus.BAD_REQUEST);
	}

}
