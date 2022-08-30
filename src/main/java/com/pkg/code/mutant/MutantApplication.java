package com.pkg.code.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MutantApplication {
	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
	}
}
