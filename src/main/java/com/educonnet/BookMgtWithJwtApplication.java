package com.educonnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BookMgtWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMgtWithJwtApplication.class, args);
	}

}
