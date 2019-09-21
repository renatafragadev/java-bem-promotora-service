package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Person;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Proposal;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.ProposalStatus;
import com.unisinos.engsoftware.bempromotoraprogram.api.repository.ProposalRepository;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.PersonService;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.ProposalService;
import com.unisinos.engsoftware.bempromotoraprogram.utils.Messages;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ExceptionCode;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ProposalException;
import com.unisinos.engsoftware.bempromotoraprogram.utils.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProposalServiceImpl implements ProposalService {

	private ProposalRepository proposalRepository;

	private PersonService personService;

	private Messages messages;

	@Autowired
	public ProposalServiceImpl(ProposalRepository proposalRepository, PersonService personService, Messages messages) {
		this.proposalRepository = proposalRepository;
		this.personService = personService;
		this.messages = messages;
	}

	@Override
	public Proposal create(Proposal proposal) {
		Person person = personService.getById(proposal.getPersonId());

		proposal.setPerson(person);
		proposal.setCreatedAt(LocalDateTime.now());

		return proposalRepository.save(proposal);
	}

	@Override
	public void update(Proposal proposal) {
		proposalRepository.save(proposal);
	}

	@Override
	public Proposal getById(Long id) {
		Optional<Proposal> proposalOpt = proposalRepository.findById(id);

		if (!proposalOpt.isPresent())
			throw new ProposalException(messages.get("exception.resource.notfound"),
					ExceptionCode.ERROR_RESOURCE_NOT_FOUND);

		return proposalOpt.get();
	}

	@Override
	public Page<Proposal> list(ProposalStatus proposalStatus, Pageable pageable) {
		Page<Proposal> proposalPage = proposalRepository.findByProposalStatus(proposalStatus, pageable);

		if (proposalPage.getNumberOfElements() == 0)
			throw new ResourceNotFoundException(messages.get("exception.resource.notfound"));

		return proposalPage;
	}
}
