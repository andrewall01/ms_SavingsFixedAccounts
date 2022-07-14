package com.project.ms.savings.fixed.accounts.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.savings.fixed.accounts.domain.dto.SavingsAccountDto;
import com.project.ms.savings.fixed.accounts.domain.services.SavingsAccountService;
import com.project.ms.savings.fixed.accounts.domain.utils.Utils;
import com.project.ms.savings.fixed.accounts.infrastructure.repository.SavingsAccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	@Autowired
	private SavingsAccountRepository savingsAccountDao;

	@Override
	public Flux<SavingsAccountDto> findAll() {
		return savingsAccountDao.findAll().map(Utils::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> findById(String id) {
		return savingsAccountDao.findById(id).map(Utils::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> save(Mono<SavingsAccountDto> savingsAccountDto) {
		return savingsAccountDto.map(Utils::dtoToEntity)
				.flatMap(savingsAccountDao::insert)
				.map(Utils::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> update(Mono<SavingsAccountDto> savingsAccountDto, String id) {
		return savingsAccountDao.findById(id)
				.flatMap(p -> savingsAccountDto
						.map(Utils::dtoToEntity)
						.doOnNext(e -> e.setId(id))
						.doOnNext(e -> e.setCreatedAt(p.getCreatedAt())))
				.flatMap(savingsAccountDao::save)
				.map(Utils::entityToDto);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return savingsAccountDao.deleteById(id);
	}

}
