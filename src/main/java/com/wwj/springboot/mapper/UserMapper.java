/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserMapper
 * Author:   13114
 * Date:     2019/6/10 22:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.mapper;

import com.wwj.springboot.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/10
 * @since 1.0.0
 */
@Component
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "sex", column = "sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "sex", column = "sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(user_name,pass_word,sex) VALUES(#{userName}, #{passWord}, #{sex})")
    int insert(User user);

    @Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(Long id);

}
