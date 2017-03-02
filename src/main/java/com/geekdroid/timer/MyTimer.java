package com.geekdroid.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by james.li on 2017/3/2.
 在程序入口的类上加上注释@EnableScheduling即可开启定时任务。
 注意： 需要在定时任务的类上加上注释：@Component，在具体的定时任务方法上加上注释@Scheduled即可启动该定时任务。
 下面描述下@Scheduled中的参数：
 @Scheduled(fixedRate=3000)：上一次开始执行时间点后3秒再次执行；
 @Scheduled(fixedDelay=3000)：上一次执行完毕时间点后3秒再次执行；
 @Scheduled(initialDelay=1000, fixedDelay=3000)：第一次延迟1秒执行，然后在上一次执行完毕时间点后3秒再次执行；
 @Scheduled(cron="* * * * * ?")：按cron规则执行。
 */
@Component
public class MyTimer {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    //每3秒执行一次
    @Scheduled(fixedRate = 3000)
    public void timerRate(){
        System.out.println("current time : "+ sdf.format(new Date()));
    }

    //第一次延迟1秒执行，当执行完后3秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void timerInit(){
        System.out.println("current time : "+ sdf.format(new Date()));
    }

    //每天23点27分50秒时执行
    @Scheduled(cron = "32 32 15 * * ?")
    public void timerCron(){
        System.out.println("current time : "+ sdf.format(new Date()));
    }
}
