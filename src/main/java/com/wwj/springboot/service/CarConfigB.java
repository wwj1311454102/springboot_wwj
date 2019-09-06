/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CarConfigB
 * Author:   13114
 * Date:     2019/6/10 16:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service;

import com.wwj.springboot.service.impl.Bc;
import org.springframework.context.annotation.Bean;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/10
 * @since 1.0.0
 */
//@Configuration
public class CarConfigB {
    @Bean("bc")
    public Bc bc() {
        return new Bc();
    }
}
