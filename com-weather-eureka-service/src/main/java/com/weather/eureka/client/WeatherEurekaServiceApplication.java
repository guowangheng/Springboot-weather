package com.weather.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.weather.*"})
public class WeatherEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaServiceApplication.class, args);
	}
}
