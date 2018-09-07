package com.weather.eureka.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guo.WangHeng on 2018/9/7.
 */

@FeignClient("com-weather-eureka-service")
public interface WeatherService {

    @RequestMapping("/getWeather/cityId/{cityId}")
    String getWeatherByCityId(String cityId);

}
