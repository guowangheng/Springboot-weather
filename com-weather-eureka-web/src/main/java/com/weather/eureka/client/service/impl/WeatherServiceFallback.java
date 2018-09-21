package com.weather.eureka.client.service.impl;

import com.weather.eureka.client.service.WeatherService;
import com.weather.model.City;
import com.weather.model.WeatherResponse;

import java.util.List;

public class WeatherServiceFallback implements WeatherService {
    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }

    @Override
    public List<City> getCityList() {
        return null;
    }
}
