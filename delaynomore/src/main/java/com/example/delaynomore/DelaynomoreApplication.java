package com.example.delaynomore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DelaynomoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelaynomoreApplication.class, args);
	}

}
