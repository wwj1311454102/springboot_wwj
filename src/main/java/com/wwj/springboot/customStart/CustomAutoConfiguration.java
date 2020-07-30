package com.wwj.springboot.customStart;

import com.wwj.springboot.dto.Student;
import com.wwj.springboot.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration//开启配置
@EnableConfigurationProperties(Student.class)//开启使用映射实体对象
@ConditionalOnClass(StudentService.class)//存在HelloService时初始化该配置类
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
        (
                prefix = "student",//存在配置前缀hello
                value = "enabled",//开启
                matchIfMissing = true//缺失检查
        )
public class CustomAutoConfiguration
{

    //application.properties配置文件映射前缀实体对象
    @Autowired
    private Student student;

    /**
     * 根据条件判断不存在HelloService时初始化新bean到SpringIoc
     * @return
     */
    @Bean//创建HelloService实体bean
    @ConditionalOnMissingBean(StudentService.class)//缺失StudentService实体bean时，初始化StudentService并添加到SpringIoc
    public StudentService studentService()
    {
        System.out.println(">>>The HelloService Not Found，Execute Create New Bean.");
        StudentService helloService = new StudentService();
        helloService.setName(student.getName());//
        helloService.setPower(student.getPower());//
        System.out.println(student.getName()+student.getPower());
        return helloService;
    }
}