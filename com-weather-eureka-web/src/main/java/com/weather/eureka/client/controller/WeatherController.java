package com.weather.eureka.client.controller;

import com.weather.eureka.client.service.WeatherService;
import com.weather.model.Weather;
import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manage")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/cityData/{citykey}", method = RequestMethod.GET)
    public WeatherResponse getCityData(Model model, @PathVariable("citykey") String citykey){

        WeatherResponse weatherByCityId = weatherService.getWeatherByCityId(citykey);

        return weatherByCityId;

    }

}
