/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SchedulerTask
 * Author:   13114
 * Date:     2019/7/1 22:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/7/1
 * @since 1.0.0
 */
@Component
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")   //没6s 一次
    private void process() {
        System.out.println("this is SchedulerTask.class runing  " + (count++));
    }

}
