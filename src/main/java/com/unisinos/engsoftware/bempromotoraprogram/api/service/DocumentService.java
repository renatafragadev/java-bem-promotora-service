package com.unisinos.engsoftware.bempromotoraprogram.api.service;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentService {

	Document create(Document document);

	void delete(Long id);

	Document getById(Long id);

	Page<Document> list(String format, Pageable pageable);
}
