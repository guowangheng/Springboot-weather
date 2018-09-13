package com.weather.eureka.client.controller;

import com.weather.eureka.client.service.WeatherService;
import com.weather.model.City;
import com.weather.model.Weather;
import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/cityData/{citykey}")
    public ModelAndView getCityData(Model model, @PathVariable("citykey") String citykey){
        WeatherResponse weatherResponse = weatherService.getWeatherByCityId(citykey);
        List<City> cityList = weatherService.getCityList();
        model.addAttribute("title","WeanGuo");
        model.addAttribute("cityList",cityList);
        model.addAttribute("citykey",citykey);
        model.addAttribute("data",weatherResponse.getData());
        ModelAndView modelAndView = new ModelAndView("/index","reportModel",model);
        return modelAndView;

    }

}
