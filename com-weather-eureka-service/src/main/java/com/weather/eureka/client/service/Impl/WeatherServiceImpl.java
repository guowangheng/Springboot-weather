package com.weather.eureka.client.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.eureka.client.service.WeatherService;
import com.weather.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    public static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        String url = WEATHER_URL +"citykey="+ cityId;
        WeatherResponse weatherResponse = this.getWeatherByURL(url);
        return weatherResponse;
    }

    @Override
    public WeatherResponse getWeatherByURL(String url) {
        WeatherResponse weatherResponse = null;
        String weatherStr = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //判断redis存不存在
            String redisKey = url;
            if (stringRedisTemplate.hasKey(redisKey)){
                LOGGER.info("redis has value");
                weatherStr = stringRedisTemplate.opsForValue().get(redisKey);
            }else{
                return null;
            }
            weatherResponse = objectMapper.readValue(weatherStr, WeatherResponse.class);
        }catch (Exception e){
            LOGGER.error("查询天气接口错误:{e}",e);
        }
        return weatherResponse;
    }


}
