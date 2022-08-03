package com.project.ms.savings.fixed.accounts.infrastructure.repository;

import java.util.Map;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingAccount;
import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

public interface RedisRepository {

  Map<String, SavingAccount> findAll();
  SavingsAccount findById(String id);
  void save(SavingAccount student);
  void delete(String id);

}
