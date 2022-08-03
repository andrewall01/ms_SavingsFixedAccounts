package com.project.ms.savings.fixed.accounts.infrastructure.repository;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingAccount;
import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

@Repository
public class SavingsAccountRedisRepository implements RedisRepository{

  private static final String KEY = "Savings";
  private RedisTemplate<String, SavingAccount> redisTemplate;
  private HashOperations hashOperations;
    
  public SavingsAccountRedisRepository(RedisTemplate<String, SavingAccount> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @PostConstruct
  private void init() {
      hashOperations = redisTemplate.opsForHash();
  }
  
  @Override
  public Map<String, SavingAccount> findAll() {    
    return hashOperations.entries(KEY);
  }

  @Override
  public SavingsAccount findById(String id) {    
    return (SavingsAccount) hashOperations.get(KEY, id);
  }

  @Override
  public void save(SavingAccount savingAccount) {
    hashOperations.put(KEY, UUID.randomUUID().toString(), savingAccount);   
  }

  @Override
  public void delete(String id) {
    hashOperations.delete(KEY, id);    
  }

}
