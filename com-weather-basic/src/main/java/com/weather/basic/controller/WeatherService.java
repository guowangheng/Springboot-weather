package com.weather.basic.controller;

import com.weather.model.WeatherResponse;

public interface WeatherService {

    WeatherResponse getWeatherByCityName(String cityName);

    WeatherResponse getWeatherByCityId(String cityId);

    WeatherResponse getWeatherByURL(String url);


}
