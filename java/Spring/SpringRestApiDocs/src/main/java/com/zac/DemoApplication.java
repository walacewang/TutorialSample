package com.zac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		context = new AnnotationConfigApplicationContext();
		context.refresh();
		context.close();

	}
}
