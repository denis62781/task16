package com.vyatsu.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.vyatsu")
@EnableJpaRepositories("com.vyatsu.repositories")
@EnableTransactionManagement
public class AppConfig {

}