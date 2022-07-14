package com.project.ms.savings.fixed.accounts.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccountDto {

	private String id;
    private String accountNumber;
    private String bankAccountCode;
    private double availableBalance;
    private String currency;
    private String holderName;
    private String holderLastName;
    private char status;
    private Date createdAt;
    private Date updatedAt;

}