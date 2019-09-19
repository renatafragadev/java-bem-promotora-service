package com.unisinos.engsoftware.bempromotoraprogram.api.repository;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Proposal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProposalRepository extends PagingAndSortingRepository<Proposal, Long> {
}
