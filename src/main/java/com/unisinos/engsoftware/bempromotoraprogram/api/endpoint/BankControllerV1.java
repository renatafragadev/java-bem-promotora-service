package com.unisinos.engsoftware.bempromotoraprogram.api.endpoint;

import com.unisinos.engsoftware.bempromotoraprogram.web.dto.BankDto;
import org.springframework.http.ResponseEntity;

public interface BankControllerV1 {

	ResponseEntity<Object> create(BankDto bankDto);

	ResponseEntity<Object> update(BankDto bankDto);

	ResponseEntity<Object> getById(Long id);

	ResponseEntity<Object> list(Integer agencyNumber, int page, int size);

}
