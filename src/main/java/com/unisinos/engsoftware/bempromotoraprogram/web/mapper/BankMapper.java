package com.unisinos.engsoftware.bempromotoraprogram.web.mapper;

import com.unisinos.engsoftware.bempromotoraprogram.api.domain.Bank;
import com.unisinos.engsoftware.bempromotoraprogram.web.dto.BankDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface BankMapper {

	BankDto toDto(Bank entity);

	Bank toEntity(BankDto dto);

	Page<BankDto> toListDto(Page<Bank> listEntity);
}
