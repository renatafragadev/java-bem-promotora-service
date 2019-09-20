package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public Person create(Person person) {
		return null;
	}

	@Override
	public void update(Person person) {

	}

	@Override
	public Person getById(Person person) {
		return null;
	}

	@Override
	public Page<Person> list(String fullName, Pageable pageable) {
		return null;
	}
}
