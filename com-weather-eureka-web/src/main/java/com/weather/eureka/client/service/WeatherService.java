package com.weather.eureka.client.service;

import com.weather.model.City;
import com.weather.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Guo.WangHeng on 2018/9/7.
 */

@FeignClient("com-weather-eureka-zuul")
public interface WeatherService {

    @GetMapping("/getWeather/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);

    @RequestMapping(value="/data/getCityList", method = RequestMethod.GET)
    List<City> getCityList();

}
