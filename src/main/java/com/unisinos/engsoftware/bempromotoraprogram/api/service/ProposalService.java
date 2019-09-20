package com.unisinos.engsoftware.bempromotoraprogram.api.service;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Proposal;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.ProposalStatus;
import org.springframework.data.domain.Page;

public interface ProposalService {

	Proposal create(Proposal proposal);

	void update(Proposal proposal);

	Proposal getById(Long id);

	Page<Proposal> list(ProposalStatus proposalStatus);

}
