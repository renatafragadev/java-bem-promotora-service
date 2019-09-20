package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2559556969920202968L;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public ResourceNotFoundException(String message) {
		super(message);
		log.warn(message);
	}
}
