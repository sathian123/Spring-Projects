package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootFirstProjectApplication.class, args);

		Alian a = context.getBean(Alian.class);
		a.show();
		
//		
//		Alian a1 = context.getBean(Alian.class);
//		a1.show();
		System.out.println("Welcome to boot...");
	}

}
