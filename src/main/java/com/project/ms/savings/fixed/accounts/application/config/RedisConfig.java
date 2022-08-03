package com.project.ms.savings.fixed.accounts.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.project.ms.savings.fixed.accounts.domain.entities.SavingAccount;

@Configuration
public class RedisConfig {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  RedisTemplate<String, SavingAccount> redisTemplate() {
    final RedisTemplate<String, SavingAccount> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }

}
