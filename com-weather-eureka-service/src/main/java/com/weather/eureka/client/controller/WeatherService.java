package com.weather.eureka.client.controller;

import com.weather.model.WeatherResponse;

public interface WeatherService {

    WeatherResponse getWeatherByCityName(String cityName);

    WeatherResponse getWeatherByCityId(String cityId);

    WeatherResponse getWeatherByURL(String url);


}
