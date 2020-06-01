package com.wwj.springboot.service.impl;

public class StudentService
{
    //消息内容
    private String name;
    //是否显示消息内容
    private String power ;

    @Override
    public String toString() {
        return "StudentService{" +
                "name='" + name + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}