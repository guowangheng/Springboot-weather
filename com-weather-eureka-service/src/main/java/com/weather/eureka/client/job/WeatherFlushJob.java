package com.weather.eureka.client.job;

import com.weather.eureka.client.controller.WeatherServiceImpl;
import com.weather.model.City;
import com.weather.model.XML;
import com.weather.utils.XMLParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class WeatherFlushJob{


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public static final String CITY_XML_URL = "http://mobile.weather.com.cn/js/citylist.xml";

    public static final Logger logger = LoggerFactory.getLogger(WeatherFlushJob.class);

    public static String cityXmlStr;

    public static List<City> cityList;

    @Autowired
    public RestTemplate restTemplate;

    private static RestTemplate restTemplateSource = new RestTemplate();



    static {
        ResponseEntity<String> cityXml = restTemplateSource.getForEntity(CITY_XML_URL, String.class);
        cityXmlStr = cityXml.getBody();
        try {
            cityList = ((XML) XMLParseUtils.xmlParse(XML.class, cityXmlStr)).getCityList().getCityList();
        } catch (JAXBException e) {
            logger.error("初始化错误",e);
        }
    }

    protected void execute() {
        logger.info("flush weather data start");
        try {
            cityList.stream().forEach(e -> flushWeatherData(e.getCityId()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        logger.info("flush weather data end");

    }

    public void flushWeatherData(String cityId){
        String redisKey = WeatherServiceImpl.WEATHER_URL + "citykey=" + cityId;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(redisKey, String.class);
        String weatherDataStr = null;
        if (forEntity.getStatusCodeValue() == 200){
            weatherDataStr = forEntity.getBody();
        }
        logger.info("save{}",weatherDataStr);
        stringRedisTemplate.opsForValue().set(redisKey,weatherDataStr, WeatherServiceImpl.SAVE_TIME,TimeUnit.SECONDS);
    }
}