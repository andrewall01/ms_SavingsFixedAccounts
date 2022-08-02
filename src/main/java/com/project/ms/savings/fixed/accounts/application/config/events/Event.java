package com.project.ms.savings.fixed.accounts.application.config.events;

import lombok.Data;
import java.util.Date;

@Data
public abstract class Event <T> {
  private String id;
  private Date date;
  private EventType type;
  private T data;

}