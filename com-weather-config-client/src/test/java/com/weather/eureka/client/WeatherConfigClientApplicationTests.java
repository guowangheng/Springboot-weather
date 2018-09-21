package com.weather.eureka.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherConfigClientApplicationTests {

    @Value("${test.name}")
    private String name;

	@Test
	public void contextLoads(){
        assertEquals(name,"aaa");
	}

}
