package com.weather.eureka.client.controller;

import com.weather.eureka.client.service.WeatherService;
import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/getWeather/cityId/{cityId}",method = RequestMethod.GET)
    public WeatherResponse getWeatherById(@PathVariable("cityId")String cityId){
        System.out.println("diaoyong....."+cityId);
        WeatherResponse weatherResponse = weatherService.getWeatherByCityId(cityId);
        return weatherResponse;
    }

}
