package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

public class BankException extends BusinessException {

	private static final long serialVersionUID = 2272625259352824309L;

	public BankException(String message, ExceptionCode exceptionCode) {
		super(message, exceptionCode);
	}
}
