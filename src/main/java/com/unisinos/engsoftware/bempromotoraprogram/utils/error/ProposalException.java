package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

public class ProposalException extends BusinessException {

	private static final long serialVersionUID = 5735809162425631567L;

	public ProposalException(String message, ExceptionCode exceptionCode) {
		super(message, exceptionCode);
	}
}
