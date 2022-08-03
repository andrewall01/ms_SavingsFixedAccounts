package com.project.ms.savings.fixed.accounts.application.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingAccount;
import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;
import com.project.ms.savings.fixed.accounts.infrastructure.repository.SavingsAccountRedisRepository;

@RestController
public class AccountController {
  private SavingsAccountRedisRepository savingRepository;
  
  public AccountController(SavingsAccountRedisRepository savingRepository) {
    this.savingRepository = savingRepository;
  }
  
  @GetMapping("/savings")
  public Map<String, SavingAccount> findAll() {
      return savingRepository.findAll();
  }

  @GetMapping("/savings/{id}")
  public SavingsAccount findById(@PathVariable String id) {
      return savingRepository.findById(id);
  }

  @PostMapping("/savings")
  public void createStudent(@RequestBody SavingAccount student) {
    savingRepository.save(student);
  }

  @DeleteMapping("/savings/{id}")
  public void deleteStudent(@PathVariable String id) {
    savingRepository.delete(id);
  }

}
