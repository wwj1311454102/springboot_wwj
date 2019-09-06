/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: test
 * Author:   13114
 * Date:     2019/6/7 15:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot;

import com.wwj.springboot.model.User;
import com.wwj.springboot.model.UserRepository;
import com.wwj.springboot.properties.UserProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/7
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private UserProperties userProperties;

    @Test
    public void testProperties() throws Exception {
        Assert.assertEquals("吴文杰", userProperties.getTitle());
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSql() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));


    }


}
