package com.project.ms.savings.fixed.accounts.domain.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("savings_accounts_redis")
public class SavingAccount implements Serializable{

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
	private String id;

	@Field("account_number")
	private String accountNumber;

	@Field("available_balance")
	private double availableBalance;

	@Field("currency")
	private String currency;

	@Field("holder_name")
	private String holderName;

	@Field("holder_last_name")
	private String holderLastName;

	@Field("status")
	private char status;

	@Field("created_at")
	@CreatedDate
	private Date createdAt;

	@Field("updated_at")
	@LastModifiedDate
	private Date updatedAt;
	
	@Field("bank_account_code")
  private String bankAccountCode;

  @Field("balance")
  private double balance;

}
