/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Student
 * Author:   admin
 * Date:     2018/12/10 17:28
 * Description: 111
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈111〉
 *
 * @author admin
 * @create 2018/12/10
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    // @Value("${student.name}")
    private String name;
//    @Value("${student.power}")
    private String power;
    private  Teacher teacher;

    private  void  doSomething(){
        System.out.println(1111);
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
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