package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Document;
import com.unisinos.engsoftware.bempromotoraprogram.api.repository.DocumentRepository;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.DocumentService;
import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	private Messages messages;

	@Autowired
	public DocumentServiceImpl(DocumentRepository documentRepository, Messages messages) {
		this.documentRepository = documentRepository;
		this.messages = messages;
	}

	@Override
	public Document create(Document document) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Document getById(Long id) {
		return null;
	}

	@Override
	public Page<Document> list(String format, Pageable pageable) {
		return null;
	}
}
