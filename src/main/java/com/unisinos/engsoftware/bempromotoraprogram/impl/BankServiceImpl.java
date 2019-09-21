package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import com.unisinos.engsoftware.bempromotoraprogram.api.repository.BankRepository;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.BankService;
import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.BankException;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionCode;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

	private BankRepository bankRepository;

	private Messages messages;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository, Messages messages) {
		this.bankRepository = bankRepository;
		this.messages = messages;
	}

	@Override
	public Bank create(Bank bank) {
		Optional<Bank> bankOpt = bankRepository.findByAgencyNumberAndAgencyDigit(bank.getAgencyNumber(),
				bank.getAgencyDigit());

		if (bankOpt.isPresent())
			throw new BankException(messages.get("exception.bank.already_exists"),
					ExceptionCode.ERROR_BANK_ALREADY_EXISTS);

		return bankRepository.save(bank);
	}

	@Override
	public void update(Bank bank) {
		bankRepository.save(bank);
	}

	@Override
	public Bank getById(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);

		if (!bankOpt.isPresent())
			throw new BankException(messages.get("exception.resource.notfound"),
					ExceptionCode.ERROR_RESOURCE_NOT_FOUND);

		return bankOpt.get();
	}

	@Override
	public Page<Bank> list(Integer agencyNumber, Pageable pageable) {
		Page<Bank> bankPage = bankRepository.findByAgencyDigit(agencyNumber, pageable);

		if (bankPage.getNumberOfElements() == 0)
			throw new ResourceNotFoundException(messages.get("exception.resource.notfound"));

		return bankPage;
	}
}
