package com.unisinos.engsoftware.bempromotoraprogram.api.repository;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface BankRepository extends PagingAndSortingRepository<Bank, Long> {

	Optional<Bank> findByAgencyNumberAndAgencyDigit(Integer agencyNumber, Integer agencyDigit);

	Page<Bank> findByAgencyDigit(@Nullable Integer agencyDigit, Pageable pageable);

}
