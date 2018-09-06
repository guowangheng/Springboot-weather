package com.weather.eureka.client.controller;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JobDetail jobDetail;

    @Autowired
    private CronTrigger cronTrigger;

    @Autowired
    private Scheduler scheduler;


    @RequestMapping("/hello")
    public String hello(){
        return "Hello Springboot";
    }

    @RequestMapping("/{prod}/quart")
    public String quartzTest(@PathVariable Integer prod) throws SchedulerException {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        String currentCron = trigger.getCronExpression();// 当前Trigger使用的
        System.err.println("当前trigger使用的-"+currentCron);
        //1秒钟执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        // 按新的cronExpression表达式重新构建trigger
        trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
                .withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
        return prod+"-这是quartz测试";
    }

}
