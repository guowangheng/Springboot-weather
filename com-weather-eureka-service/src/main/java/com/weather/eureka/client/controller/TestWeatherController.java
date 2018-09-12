package com.weather.eureka.client.controller;

import com.weather.eureka.client.service.WeatherService;
import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestWeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getWeather/cityId/{cityId}")
    public WeatherResponse getWeatherById(@PathVariable("cityId")String cityId){
        System.out.println("diaoyong....."+cityId);
        WeatherResponse weatherResponse = weatherService.getWeatherByCityId(cityId);
        return weatherResponse;
    }

}
