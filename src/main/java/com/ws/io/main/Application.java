package com.ws.io.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ws.io")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
