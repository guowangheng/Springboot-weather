package com.weather.eureka.client.service;

import com.weather.model.WeatherResponse;


public interface WeatherService {

    WeatherResponse getWeatherByCityId(String cityId);

    WeatherResponse getWeatherByURL(String url);


}
