package com.project.ms.savings.fixed.accounts.domain.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.project.ms.savings.fixed.accounts.application.config.events.Event;
import com.project.ms.savings.fixed.accounts.application.config.events.EventType;
import com.project.ms.savings.fixed.accounts.application.config.events.SavingAccountCreatedEvent;
import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

@Component
public class SavingsAccountServiceEvents {
  
  @Autowired
  private KafkaTemplate<String, Event<?>> producer;
  
  @Value("${topic.customer.name:savings}")
  private String topicSaving;
  
  public void publish(SavingsAccount savingAccount) {
    
    SavingAccountCreatedEvent created = new SavingAccountCreatedEvent();
    created.setData(savingAccount);
    created.setId(UUID.randomUUID().toString());
    created.setType(EventType.CREATED);
    created.setDate(new Date());
    
    this.producer.send(topicSaving, created);
    
  }

}
