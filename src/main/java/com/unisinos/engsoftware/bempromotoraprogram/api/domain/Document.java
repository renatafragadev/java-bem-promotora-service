package com.unisinos.engsoftware.bempromotoraprogram.api.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Document implements Serializable {

    private static final long serialVersionUID = 2474051434220453025L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String format;

    private String content;

    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private SendType sendType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SendType getSendType() {
        return sendType;
    }

    public void setSendType(SendType sendType) {
        this.sendType = sendType;
    }
}
