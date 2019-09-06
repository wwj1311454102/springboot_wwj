/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Bmw
 * Author:   13114
 * Date:     2019/6/10 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service.impl;

import com.wwj.springboot.service.Car;
import org.springframework.stereotype.Component;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/10
 * @since 1.0.0
 */
@Component
public class Bmw implements Car {

    @Override
    public void print() {
        System.out.println("宝马");
    }
}
