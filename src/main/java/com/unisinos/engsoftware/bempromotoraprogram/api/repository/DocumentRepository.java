package com.unisinos.engsoftware.bempromotoraprogram.api.repository;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Long> {

	Page<Document> findByFormat(@Nullable String format, Pageable pageable);
}
