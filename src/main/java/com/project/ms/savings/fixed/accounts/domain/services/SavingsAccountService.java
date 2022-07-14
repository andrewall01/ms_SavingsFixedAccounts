package com.project.ms.savings.fixed.accounts.domain.services;

import com.project.ms.savings.fixed.accounts.domain.dto.SavingsAccountDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SavingsAccountService {

	public Flux<SavingsAccountDto> findAll();

	public Mono<SavingsAccountDto> findById(String id);

	public Mono<SavingsAccountDto> save(Mono<SavingsAccountDto> savingsAccountDto);

	public Mono<SavingsAccountDto> update(Mono<SavingsAccountDto> savingsAccountDto, String id);

	public Mono<Void> deleteById(String id);

}