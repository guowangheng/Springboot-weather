package com.weather.eureka.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.weather.eureka.client.service.WeatherService;
import com.weather.model.City;
import com.weather.model.Forecast;
import com.weather.model.Weather;
import com.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/manage")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/cityData/{citykey}")
    @HystrixCommand(fallbackMethod = "getCityDataFail")
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

    public ModelAndView getCityDataFail(Model model, String citykey){
        model.addAttribute("title","WeanGuo");
        City city = new City();
        city.setCityId("111");
        city.setCityCode("111");
        city.setCityName("aaa");
        city.setProvince("aaaa");
        WeatherResponse weatherResponse = new WeatherResponse();
        Weather weather = new Weather();
        weather.setAqi("1");
        weather.setCity("111");
        ModelAndView modelAndView = new ModelAndView("index", "reportModel", model);
        return modelAndView;
    }

}
