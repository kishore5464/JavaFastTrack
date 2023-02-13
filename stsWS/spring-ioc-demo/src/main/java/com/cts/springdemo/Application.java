package com.cts.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.springdemo.ui.HomeUI;

public class Application {

	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
