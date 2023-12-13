package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*This Class is responsible for initializing Spring Boot Application and setting up Application context*/

@SpringBootApplication
public class SpringProject1Application {
	
	/*main method serves as the entry point for Spring Boot application*/
	
	public static void main(String[] args) {
		
		/*SpringApplication is a class part of Spring Boot Framework and provides methods to launch a Spring application from java main method
		 * run is a method to initialize application context, performs class path scanning for components like controller, service, repository..etc */
		
		SpringApplication.run(SpringProject1Application.class, args);
	}

}
