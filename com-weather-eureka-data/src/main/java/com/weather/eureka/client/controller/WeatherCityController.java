package com.weather.eureka.client.controller;

import com.weather.eureka.client.job.WeatherFlushJob;
import com.weather.model.City;
import com.weather.model.CityList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Guo.WangHeng on 2018/9/12.
 */
@RestController
@RequestMapping("/data")
public class WeatherCityController {

    @RequestMapping(value = "getCityList", method = RequestMethod.POST)
    public List<City> getCityList(){
        List<City> cityList = WeatherFlushJob.cityList;
        return cityList;
    }


}
