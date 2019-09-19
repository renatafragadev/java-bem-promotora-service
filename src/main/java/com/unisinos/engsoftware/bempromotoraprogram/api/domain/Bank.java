package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Bank implements Serializable {

    private static final long serialVersionUID = -6779369121677889362L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
