package com.project.ms.savings.fixed.accounts.domain.services;

import com.project.ms.savings.fixed.accounts.domain.dto.FixedAccountDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FixedAccountService {

	public Flux<FixedAccountDto> findAll();

	public Mono<FixedAccountDto> findById(String id);

	public Mono<FixedAccountDto> save(Mono<FixedAccountDto> fixedAccountDto);

	public Mono<FixedAccountDto> update(Mono<FixedAccountDto> fixedAccountDto, String id);

	public Mono<Void> deleteById(String id);

}