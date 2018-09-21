package com.weather.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = {"com.weather.*"})
public class WeatherEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaServerApplication.class, args);
	}
}
