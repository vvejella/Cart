package com.my.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CartApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
		System.out.println("heloo");
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CartApplication.class);
    }
}
