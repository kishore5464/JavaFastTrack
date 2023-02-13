package com.cts.springdemo;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.springdemo")
@PropertySource("classpath:application.properties")
public class MyConfig {
	 
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}
