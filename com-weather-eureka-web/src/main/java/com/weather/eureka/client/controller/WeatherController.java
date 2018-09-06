package com.weather.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class WeatherController {

    /*@Autowired
    private WeatherService weatherService;

    @RequestMapping("/cityData/{citykey}")
    public ModelAndView getCityData(Model model, @PathVariable("citykey") String citykey){
        Weather weather = weatherService.getWeatherByCityId(citykey).getData();
        model.addAttribute("data", weather);
        model.addAttribute("title", "WeanGuo");
        model.addAttribute("citykey",citykey);
        model.addAttribute("cityList",WeatherFlushJob.cityList);
        return new ModelAndView("/index","reportModel",model);
    }*/

}
