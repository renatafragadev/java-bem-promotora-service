package com.unisinos.engsoftware.bempromotoraprogram.api.repository;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	Page<Person> findByFullNameContaining(String fullName, Pageable pageable);

}
