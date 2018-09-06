package com.weather.eureka.client.controller;

import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getWeather")
public class TestWeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByName(@PathVariable("cityName")String cityName){
        WeatherResponse weatherResponse = weatherService.getWeatherByCityName(cityName);
        return weatherResponse;
    }

    @RequestMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherById(@PathVariable("cityId")String cityId){
        WeatherResponse weatherResponse = weatherService.getWeatherByCityId(cityId);
        return weatherResponse;
    }

}
