package com.project.ms.savings.fixed.accounts.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.savings.fixed.accounts.domain.dto.FixedAccountDto;
import com.project.ms.savings.fixed.accounts.domain.services.FixedAccountService;
import com.project.ms.savings.fixed.accounts.domain.utils.Utils;
import com.project.ms.savings.fixed.accounts.infrastructure.repository.FixedAccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FixedAccountServiceImpl implements FixedAccountService {

	@Autowired
	private FixedAccountRepository fixedAccountDao;

	@Override
	public Flux<FixedAccountDto> findAll() {
		return fixedAccountDao.findAll().map(Utils::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> findById(String id) {
		return fixedAccountDao.findById(id).map(Utils::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> save(Mono<FixedAccountDto> fixedAccountDto) {
		return fixedAccountDto.map(Utils::dtoToEntity)
				.flatMap(fixedAccountDao::insert).map(Utils::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> update(Mono<FixedAccountDto> fixedAccountDto, String id) {
		return fixedAccountDao.findById(id)
				.flatMap(p -> fixedAccountDto.map(Utils::dtoToEntity)
						.doOnNext(e -> e.setId(id))
						.doOnNext(e -> e.setCreatedAt(p.getCreatedAt())))
				.flatMap(fixedAccountDao::save).map(Utils::entityToDto);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return fixedAccountDao.deleteById(id);
	}

}
