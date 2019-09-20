package com.unisinos.engsoftware.bempromotoraprogram.utils.error;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "timestamp", "code", "message", "detail" })
public class ExceptionsDetails {

	private String code;

	private String detail;

	private long timestamp;

	private String message;

	public ExceptionsDetails(String title, String code, String detail, long timestamp, String message) {
		this.code = code;
		this.detail = detail;
		this.timestamp = timestamp;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

}
