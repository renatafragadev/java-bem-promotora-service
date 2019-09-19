package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    private static final long serialVersionUID = 502753919229568054L;

    private LocalDateTime registration;

    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }
}
