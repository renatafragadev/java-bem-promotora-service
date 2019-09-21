package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

public class PersonException extends BusinessException {

	private static final long serialVersionUID = -1708327180902465252L;

	public PersonException(String message, ExceptionCode exceptionCode) {
		super(message, exceptionCode);
	}
}
