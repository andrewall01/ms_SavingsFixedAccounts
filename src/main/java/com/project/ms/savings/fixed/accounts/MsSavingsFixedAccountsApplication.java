package com.project.ms.savings.fixed.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class MsSavingsFixedAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSavingsFixedAccountsApplication.class, args);
	}

}
