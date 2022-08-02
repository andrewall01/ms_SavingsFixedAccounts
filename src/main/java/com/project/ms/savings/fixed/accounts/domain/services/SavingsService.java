package com.project.ms.savings.fixed.accounts.domain.services;

import org.springframework.stereotype.Service;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

@Service
public class SavingsService {
  
  private final SavingsAccountServiceEvents accountServiceEvents;
  
  public SavingsService(SavingsAccountServiceEvents accountServiceEvents) {
    super();
    this.accountServiceEvents = accountServiceEvents;
  }
  
  public SavingsAccount save(SavingsAccount savingAccount) {
    System.out.println("Received " + savingAccount);
    this.accountServiceEvents.publish(savingAccount);
    return savingAccount;
  }

}
