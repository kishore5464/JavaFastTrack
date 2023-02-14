package com.cts.sbdd;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDataDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataDemoApplication.class, args);
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public DateTimeFormatter dateFormatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}
}
