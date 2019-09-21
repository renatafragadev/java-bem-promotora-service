package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import com.unisinos.engsoftware.bempromotoraprogram.api.repository.PersonRepository;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.BankService;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.PersonService;
import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionCode;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	private BankService bankService;

	private Messages messages;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository, BankService bankService, Messages messages) {
		this.personRepository = personRepository;
		this.bankService = bankService;
		this.messages = messages;
	}

	@Override
	public Person create(Person person) {
		Bank bank = bankService.getById(person.getBankId());
		person.setBank(bank);
		return personRepository.save(person);
	}

	@Override
	public void update(Person person) {
		personRepository.save(person);
	}

	@Override
	public Person getById(Long id) {
		Optional<Person> personOpt = personRepository.findById(id);

		if (!personOpt.isPresent())
			throw new PersonException(messages.get("exception.resource.not_found"),
					ExceptionCode.ERROR_RESOURCE_NOT_FOUND);

		return personOpt.get();
	}

	@Override
	public Page<Person> list(String fullName, Pageable pageable) {
		Page<Person> personPage = personRepository.findByFullNameContaining(fullName, pageable);

		if (personPage.getNumberOfElements() == 0)
			throw new PersonException(messages.get("exception.resource.not_found"),
					ExceptionCode.ERROR_RESOURCE_NOT_FOUND);

		return personPage;
	}
}
