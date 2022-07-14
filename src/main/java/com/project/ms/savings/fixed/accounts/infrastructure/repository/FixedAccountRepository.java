package com.project.ms.savings.fixed.accounts.infrastructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.ms.savings.fixed.accounts.domain.entities.FixedAccount;

@Repository
public interface FixedAccountRepository extends ReactiveMongoRepository<FixedAccount, String>{

}