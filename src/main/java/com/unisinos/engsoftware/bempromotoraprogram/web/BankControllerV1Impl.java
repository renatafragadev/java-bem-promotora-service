package com.unisinos.engsoftware.bempromotoraprogram.web;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import com.unisinos.engsoftware.bempromotoraprogram.api.endpoint.BankControllerV1;
import com.unisinos.engsoftware.bempromotoraprogram.api.service.BankService;
import com.unisinos.engsoftware.bempromotoraprogram.web.dto.BankDto;
import com.unisinos.engsoftware.bempromotoraprogram.web.mapper.BankMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/bank", produces = MediaType.APPLICATION_JSON_VALUE)
public class BankControllerV1Impl implements BankControllerV1 {

	@Autowired
	private BankService bankService;

	private BankMapper bankMapper;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody BankDto bankDto) {
		log.info("BankEndpoint: create -> params: bankDto - {} ", bankDto);
		Bank bank = bankMapper.toEntity(bankDto);
		bank = bankService.create(bank);
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("id", bank.getId());
		response.put("agencyNumber", bank.getAgencyNumber());
		response.put("agencyDigit", bank.getAgencyDigit());
		log.info("BankEndpoint: create -> response: HttpStatus - {} ", HttpStatus.OK);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody BankDto bankDto) {
		log.info("BankEndpoint: update -> params: bankDto - {} ", bankDto);
		Bank bank = bankMapper.toEntity(bankDto);
		bankService.update(bank);
		log.info("BankEndpoint: update -> response: HttpStatus - {} ", HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	@GetMapping(value = "{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
		log.info("BankEndpoint: getById -> params: id - {} ", id);
		Bank bank = bankService.getById(id);
		BankDto bankDto = bankMapper.toDto(bank);
		log.info("BankEndpoint: getById -> response: bankDto - {} ", bankDto);
		return new ResponseEntity<>(bankDto, HttpStatus.OK);
	}

	@Override
	@GetMapping(value = "/list")
	public ResponseEntity<Object> list(@RequestParam Integer agencyNumber,
	                                   @RequestParam(defaultValue = "0") int page,
	                                   @RequestParam(defaultValue = "10") int size) {
		log.info("BankEndpoint: list -> params: agencyNumber - {}, page - {}, size - {} ",
				agencyNumber, page, size);
		//TODO

		return null;
	}
}
