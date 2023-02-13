package com.cts.springdemo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.springdemo.service.GreetService;

@Component
public class HomeUI {
	
	@Value("${app.title:UNNAMED}")
	private String appTitle;
	
	@Autowired
	private Scanner scanner;

	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;
	
	public void run() {
		System.out.println(appTitle);
		System.out.println("------------------------------------------------------");
		
		System.out.println("Your Name ? ");
		String userName = scanner.next();
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
		
	}
}
