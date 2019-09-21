package com.unisinos.engsoftware.bempromotoraprogram.api.service;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

	Person create(Person person);

	void update(Person person);

	Person getById(Long id);

	Page<Person> list(String fullName, Pageable pageable);

}
