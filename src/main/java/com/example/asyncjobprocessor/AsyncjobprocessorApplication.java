package com.example.asyncjobprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncjobprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncjobprocessorApplication.class, args);
	}

}
