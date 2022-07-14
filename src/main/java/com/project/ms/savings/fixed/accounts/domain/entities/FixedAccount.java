package com.project.ms.savings.fixed.accounts.domain.entities;

import java.util.Date;

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
@Document("fixed_accounts")
public class FixedAccount extends Account {

    @Field("balance")
    private double balance;

    @Field("initial_date")
    private Date initialDate;

    @Field("end_date")
    private Date endDate;
}