package com.weather.eureka.client.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.weather.*"})
@EnableEurekaServer
public class WeatherEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaServerApplication.class, args);
	}
}
