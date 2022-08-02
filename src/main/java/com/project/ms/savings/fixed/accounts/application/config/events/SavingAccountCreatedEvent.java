package com.project.ms.savings.fixed.accounts.application.config.events;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingAccountCreatedEvent extends Event<SavingsAccount> {

}
