/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Scheduler2Task
 * Author:   13114
 * Date:     2019/7/1 22:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*@Scheduled 参数可以接受两种定时的设置一种是我们常用的cron="* /6 * * * * ?",一种是 fixedRate = 6000,两种都表示每隔六秒打印一下内容。

        fixedRate 说明

@Scheduled(fixedRate = 6000)上一次开始执行时间点之后6秒再执行
@Scheduled(fixedDelay = 6000)上一次执行完毕时间点之后6秒再执行
@Scheduled(initialDelay=1000, fixedRate=6000)第一次延迟1秒后执行,之后按 fixedRate 的规则每6秒执行一次*/
@Component
public class Scheduler2Task {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate2(LocalDateTime date) {
        return formatter.format(date);
    }

    public static LocalDateTime parse2(String dateNow) {
        return LocalDateTime.parse(dateNow, formatter);
    }

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + formatDate2(LocalDateTime.now()));
        System.out.println("现在时间：" + parse2(formatDate2(LocalDateTime.now())));
//      ClassLoader.getSystemClassLoader().loadClass("user");

    }

}