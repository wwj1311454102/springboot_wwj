/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserRepository
 * Author:   13114
 * Date:     2019/6/7 16:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 〈描述〉<br>
 * 〈〉jpa 查询
 *
 * @author 13114
 * @create 2019/6/7
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    Page<User> findAll(Pageable pageable);

    @Query("select u from User u where u.userName = ?1")
    User findUser(String userName);


}
