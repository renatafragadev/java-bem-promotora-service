package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Document;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import com.unisinos.engsoftware.bempromotoraprogram.api.repository.DocumentRepository;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.DocumentService;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.PersonService;
import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.DocumentException;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionCode;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	private PersonService personService;

	private Messages messages;

	@Autowired
	public DocumentServiceImpl(DocumentRepository documentRepository, PersonService personService, Messages messages) {
		this.documentRepository = documentRepository;
		this.personService = personService;
		this.messages = messages;
	}

	@Override
	public Document create(Document document) {
		Person person = personService.getById(document.getPersonId());
		document.setPerson(person);

		return documentRepository.save(document);
	}

	@Override
	public void delete(Long id) {
		Document document = getById(id);

		documentRepository.delete(document);
	}

	@Override
	public Document getById(Long id) {
		Optional<Document> documentOpt = documentRepository.findById(id);

		if (!documentOpt.isPresent())
			throw new DocumentException(messages.get("exception.resource.notfound"),
					ExceptionCode.ERROR_RESOURCE_NOT_FOUND);

		return documentOpt.get();
	}

	@Override
	public Page<Document> list(String format, Pageable pageable) {
		Page<Document> documentPage = documentRepository.findByFormat(format, pageable);

		if (documentPage.getNumberOfElements() == 0)
			throw new ResourceNotFoundException(messages.get("exception.resource.notfound"));

		return documentPage;
	}
}
