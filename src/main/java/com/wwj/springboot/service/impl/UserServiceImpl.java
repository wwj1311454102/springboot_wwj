/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   13114
 * Date:     2019/6/11 20:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service.impl;

import com.wwj.springboot.mapper.UserMapper;
import com.wwj.springboot.model.User;
import com.wwj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/11
 * @since 1.0.0
 */
@Service()
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        List<User> user = userMapper.getAll();
        return user;
    }

    @Override
    @Transactional
    public int saveUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }

    @Override
    public int deleteUser(long id) {
        int i = userMapper.delete(id);
        return i;
    }
}
