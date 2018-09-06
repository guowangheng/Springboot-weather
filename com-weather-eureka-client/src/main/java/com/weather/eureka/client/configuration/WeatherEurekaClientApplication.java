package com.weather.eureka.client.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.weather.*"})
public class ComWeatherBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComWeatherBasicApplication.class, args);
	}
}
