/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: User
 * Author:   wuwj
 * Date:     2020/7/16 13:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * WUWJ           2020/7/16 13:04      1.0.0              初始化
 */
package com.wwj.springboot.pojo;

import lombok.Data;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author wuwj
 * @create 2020/7/16
 * @since 1.0.0
 */
@Data
public class User {
    private  String name ;
    private  int age ;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
