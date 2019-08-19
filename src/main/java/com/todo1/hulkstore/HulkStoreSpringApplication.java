package com.todo1.hulkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Starter del proyecto
 * 
 * @author marfernandez
 *
 */

@SpringBootApplication
@ComponentScan
@Configuration
public class HulkStoreSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HulkStoreSpringApplication.class, args);
	}
}
