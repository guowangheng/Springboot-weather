package com.weather.basic.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.City;
import com.weather.model.WeatherResponse;
import com.weather.utils.XMLParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    public static final Long SAVE_TIME = 1800L;

    public static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);



    @Override
    public WeatherResponse getWeatherByCityName(String cityName) {
        String url = WEATHER_URL +"city="+ cityName;
        WeatherResponse weatherResponse = this.getWeatherByURL(url);
        return weatherResponse;
    }

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
                LOGGER.info("redis not has value");
                ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
                int statusCode = forEntity.getStatusCodeValue();
                if (statusCode == 200){
                    //objectMapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ;
                    objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
                    weatherStr = forEntity.getBody();
                    LOGGER.info("redis save value");
                    stringRedisTemplate.opsForValue().set(url,weatherStr,SAVE_TIME,TimeUnit.SECONDS);
                }
            }
            weatherResponse = objectMapper.readValue(weatherStr, WeatherResponse.class);
        }catch (Exception e){
            LOGGER.error("查询天气接口错误:{e}",e);
        }
        return weatherResponse;
    }


}
