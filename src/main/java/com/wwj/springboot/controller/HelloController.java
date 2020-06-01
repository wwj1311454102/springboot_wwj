package com.wwj.springboot.controller;

import com.wwj.springboot.dto.Student;
import com.wwj.springboot.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.mail.Address;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 *
 * @author: @我没有三颗心脏
 * @create: 2018-05-08-下午 16:46
 */
@RestController
public class HelloController {
    @Autowired
    private Student student;

    @Autowired
    private UserProperties userProperties;


    @Autowired
    private HttpServletRequest request;

    /*    @Autowired
        private HttpServletResponse response;*/
    @RequestMapping("/hello")
    public String hello() {
        Map<String, String> map = new HashMap<String, String>();
        boolean a;
        int b ;
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);

        }
        System.out.println(map.toString());
        String name = request.getHeader("name");
        System.out.println(name);
        return student.getName() + student.getPower() + userProperties.getTitle();
//        return r    equest.getHeader("name");

    }
}