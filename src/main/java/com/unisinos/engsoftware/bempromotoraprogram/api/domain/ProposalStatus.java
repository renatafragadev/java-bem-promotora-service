package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

public enum ProposalStatus {
    INCLUDE(10),
    PENDING(20),
    PENDING_DOC(30),
    SEND_AGREEMENT(50),
    WAITING_PAYMENT(60),
    APPROVED(100),
    DISAPPROVED(21),
    DISAPPROVED_AGREEMENT(51),
    CANCELED(101);

    private final int value;

    ProposalStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
