package com.unisinos.engsoftware.bempromotoraprogram.api.service;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BankService {

	Bank create(Bank bank);

	void update(Bank bank);

	Bank getById(Long id);

	Page<Bank> list(Integer agencyNumber, Pageable pageable);
}
