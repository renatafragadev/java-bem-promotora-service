package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Person {

    private static final long serialVersionUID = -8390876580632565927L;

    private String motherName;

    private String agreementRegistration;

    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private Agreement agreement;

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAgreementRegistration() {
        return agreementRegistration;
    }

    public void setAgreementRegistration(String agreementRegistration) {
        this.agreementRegistration = agreementRegistration;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }
}
