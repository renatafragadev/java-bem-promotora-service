package com.unisinos.engsoftware.bempromotoraprogram.web.dto;

import java.io.Serializable;

public class BankDto implements Serializable {
	private static final long serialVersionUID = 3632392952145077386L;

	private Long id;

	private String cep;

	private Integer agencyNumber;

	private Integer agencyDigit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(Integer agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public Integer getAgencyDigit() {
		return agencyDigit;
	}

	public void setAgencyDigit(Integer agencyDigit) {
		this.agencyDigit = agencyDigit;
	}

	@Override
	public String toString() {
		return "BankDto{" +
				"id=" + id +
				", cep='" + cep + '\'' +
				", agencyNumber=" + agencyNumber +
				", agencyDigit=" + agencyDigit +
				'}';
	}
}
