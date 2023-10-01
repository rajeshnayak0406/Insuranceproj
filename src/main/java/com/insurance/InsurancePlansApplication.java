package com.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
public class InsurancePlansApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsurancePlansApplication.class, args);
	}

}
