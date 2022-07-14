package com.project.ms.savings.fixed.accounts.domain.utils;

import org.springframework.beans.BeanUtils;

import com.project.ms.savings.fixed.accounts.domain.dto.FixedAccountDto;
import com.project.ms.savings.fixed.accounts.domain.dto.SavingsAccountDto;
import com.project.ms.savings.fixed.accounts.domain.entities.FixedAccount;
import com.project.ms.savings.fixed.accounts.domain.entities.SavingsAccount;

public class Utils {
	public static SavingsAccountDto entityToDto(SavingsAccount savingsAccount) {
		SavingsAccountDto savingsAccountDto = new SavingsAccountDto();
		BeanUtils.copyProperties(savingsAccount, savingsAccountDto);
		return savingsAccountDto;
	}

	public static SavingsAccount dtoToEntity(SavingsAccountDto savingsAccountDto) {
		SavingsAccount savingsAccount = new SavingsAccount();
		BeanUtils.copyProperties(savingsAccountDto, savingsAccount);
		return savingsAccount;
	}

	public static FixedAccountDto entityToDto(FixedAccount fixedAccount) {
		FixedAccountDto fixedAccountDto = new FixedAccountDto();
		BeanUtils.copyProperties(fixedAccount, fixedAccountDto);
		return fixedAccountDto;
	}

	public static FixedAccount dtoToEntity(FixedAccountDto fixedAccountDto) {
		FixedAccount fixedAccount = new FixedAccount();
		BeanUtils.copyProperties(fixedAccountDto, fixedAccount);
		return fixedAccount;
	}
}
