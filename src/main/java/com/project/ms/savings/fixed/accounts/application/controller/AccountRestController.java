package com.project.ms.savings.fixed.accounts.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ms.savings.fixed.accounts.domain.dto.FixedAccountDto;
import com.project.ms.savings.fixed.accounts.domain.dto.SavingsAccountDto;
import com.project.ms.savings.fixed.accounts.domain.services.FixedAccountService;
import com.project.ms.savings.fixed.accounts.domain.services.SavingsAccountService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

  @Autowired
  private SavingsAccountService savingsAccountService;

  @Autowired
  private FixedAccountService fixedAccountService;

  // Savings Account endpoints
  @GetMapping("/savings")
  public Flux<SavingsAccountDto> getAllSavings() {
    return savingsAccountService.findAll();
  }

  @CircuitBreaker(name = "AccountsCB", fallbackMethod = "fallBackGetAccounts")
  @GetMapping("/savings/{id}")
  public Mono<SavingsAccountDto> getSavings(@PathVariable String id) {
    return savingsAccountService.findById(id);
  }

  @PostMapping("/savings/save")
  public Mono<SavingsAccountDto> saveSavings(
      @RequestBody Mono<SavingsAccountDto> savingsAccountDto) {
    return savingsAccountService.save(savingsAccountDto);
  }

  @PutMapping("/savings/update/{id}")
  public Mono<SavingsAccountDto> updateSavings(
      @RequestBody Mono<SavingsAccountDto> savingsAccountDto,
      @PathVariable String id) {
    return savingsAccountService.update(savingsAccountDto, id);
  }

  @DeleteMapping("/savings/delete/{id}")
  public Mono<Void> deleteSavings(@PathVariable String id) {
    return savingsAccountService.deleteById(id);
  }

  // Fixed Account endpoints
  @GetMapping("/fixed")
  public Flux<FixedAccountDto> getAllFixed() {
    return fixedAccountService.findAll();
  }

  @GetMapping("/fixed/{id}")
  public Mono<FixedAccountDto> getFixed(@PathVariable String id) {
    return fixedAccountService.findById(id);
  }

  @PostMapping("/fixed/save")
  public Mono<FixedAccountDto> saveFixed(
      @RequestBody Mono<FixedAccountDto> fixedAccountDto) {
    return fixedAccountService.save(fixedAccountDto);
  }

  @PutMapping("/fixed/update/{id}")
  public Mono<FixedAccountDto> updateFixed(
      @RequestBody Mono<FixedAccountDto> fixedAccountDto,
      @PathVariable String id) {
    return fixedAccountService.update(fixedAccountDto, id);
  }

  @DeleteMapping("/fixed/delete/{id}")
  public Mono<Void> deleteFixed(@PathVariable String id) {
    return fixedAccountService.deleteById(id);
  }

  public Mono<SavingsAccountDto> fallBackGetAccounts(
      @PathVariable("id") String id, Throwable e) {
    SavingsAccountDto account = new SavingsAccountDto();
    account.setAccountNumber("Not account information");

    return Mono.just(account);
  }

}
