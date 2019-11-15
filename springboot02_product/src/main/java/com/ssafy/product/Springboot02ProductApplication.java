package com.ssafy.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ssafy"})
public class Springboot02ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02ProductApplication.class, args);
	}

}
