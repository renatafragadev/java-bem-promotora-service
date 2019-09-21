package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

public class DocumentException extends BusinessException {

	private static final long serialVersionUID = -8369067645935540496L;

	public DocumentException(String message, ExceptionCode exceptionCode) {
		super(message, exceptionCode);
	}
}
