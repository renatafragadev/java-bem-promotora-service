package com.unisinos.engsoftware.bempromotoraprogram.impl;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Proposal;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.ProposalStatus;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.ProposalService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService {

	@Override
	public Proposal create(Proposal proposal) {
		return null;
	}

	@Override
	public void update(Proposal proposal) {

	}

	@Override
	public Proposal getById(Long id) {
		return null;
	}

	@Override
	public Page<Proposal> list(ProposalStatus proposalStatus) {
		return null;
	}
}
