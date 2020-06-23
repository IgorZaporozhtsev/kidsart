package com.zeecoder.kidsart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class KidsartApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidsartApplication.class, args);
	}

}
