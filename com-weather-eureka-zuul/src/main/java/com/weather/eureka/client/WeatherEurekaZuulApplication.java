package com.weather.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
public class WeatherEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherEurekaZuulApplication.class, args);
        System.out.println("bbbb");
	}
}
