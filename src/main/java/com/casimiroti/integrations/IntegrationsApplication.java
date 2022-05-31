package com.casimiroti.integrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class IntegrationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationsApplication.class, args);
	}

}
