package com.weather.basic.controller;

import com.weather.basic.job.WeatherFlushJob;
import com.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manage")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/cityData/{citykey}")
    public ModelAndView getCityData(Model model, @PathVariable("citykey") String citykey){
        Weather weather = weatherService.getWeatherByCityId(citykey).getData();
        model.addAttribute("data", weather);
        model.addAttribute("citykey",citykey);
        model.addAttribute("cityList",WeatherFlushJob.cityList);
        return new ModelAndView("/index","modelIndex",model);
    }

}
