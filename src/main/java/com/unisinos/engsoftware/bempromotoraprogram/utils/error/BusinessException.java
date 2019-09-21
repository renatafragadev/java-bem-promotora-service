package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 2568590887049157384L;

	private final ExceptionCode exceptionCode;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public BusinessException(String message, ExceptionCode exceptionCode) {
		super(message);
		this.exceptionCode = exceptionCode;
		log.warn(exceptionCode.toString());
	}

	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}

}
