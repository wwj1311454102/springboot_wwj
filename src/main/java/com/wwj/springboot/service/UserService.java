/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   13114
 * Date:     2019/6/11 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service;

import com.wwj.springboot.model.User;

import java.util.List;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/11
 * @since 1.0.0
 */


public interface UserService {
    public List<User> getAllUser();

    public int saveUser(User user);

    public int deleteUser(long id);

    public User selectUserById(long id);

}
