package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {

    private static final long serialVersionUID = 2232623471495833110L;

    @TableGenerator(name = "PERSON_GEN", table = "PERSON_ID_GEN", pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PERSON_GEN")
    private Long id;

    private String document;

    @Column(length = 4)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    private String fullName;

    private LocalDateTime dateOfBirth;

    private String email;

    private String phoneNumber;

    private String cep;

    private String rg;

    private String issuingOrgan;

    private LocalDateTime issuingDate;

    private String state;

    private Integer accountNumber;

    private Integer accountDigit;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bank_id")
    private Bank bank;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    private List<Document> documentList;

    @Transient
    private Long bankId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getIssuingOrgan() {
        return issuingOrgan;
    }

    public void setIssuingOrgan(String issuingOrgan) {
        this.issuingOrgan = issuingOrgan;
    }

    public LocalDateTime getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(LocalDateTime issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(Integer accountDigit) {
        this.accountDigit = accountDigit;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }
}
