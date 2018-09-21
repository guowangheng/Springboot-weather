package com.weather.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/getName")
    public String getName(){
        return foo;
    }

}
