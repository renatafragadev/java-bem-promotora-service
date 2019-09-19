package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

public enum Sex {
    FEMALE("F"),
    MALE("M");

    private final String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
