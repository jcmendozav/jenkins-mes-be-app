package com.mes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan({ "com.controller" })
@EnableJpaRepositories({ "com.repository" })
@EntityScan({ "com.model" })
public class MESBEApplication {

	public static void main(String[] args) {
		SpringApplication.run(MESBEApplication.class, args);
	}

}
