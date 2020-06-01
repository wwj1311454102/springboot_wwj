package com.wwj.springboot.springbootconfig;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            System.out.println("-----系统初始化...");
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
                System.out.println("----初始化异常...");
                e.printStackTrace();
            }
            System.out.println("-----初始化完成...");
        }
    }
}