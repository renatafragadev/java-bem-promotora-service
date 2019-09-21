package com.unisinos.engsoftware.bempromotoraprogram.api.repository;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Proposal;
import com.unisinos.engsoftware.bempromotoraprogram.api.domain.ProposalStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProposalRepository extends PagingAndSortingRepository<Proposal, Long> {

	Page<Proposal> findByProposalStatus(ProposalStatus proposalStatus, Pageable pageable);

}
