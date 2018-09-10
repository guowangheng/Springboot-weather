package com.weather.eureka.client.service;

import com.weather.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Guo.WangHeng on 2018/9/7.
 */

@FeignClient(value = "com-weather-eureka-service")
public interface WeatherService {

    @RequestMapping(value="/getWeather/cityId/{cityId}", method = RequestMethod.GET)
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);

}
