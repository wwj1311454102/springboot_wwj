/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyApplicationContextInitializer
 * Author:   WUWJ
 * Date:     2020/6/1 22:30
 * Description: 自定义ApplicationContextInitializer
 * History:
 * <author>          <time>          <version>          <desc>
 * WUWJ           2020/6/1 22:30      1.0.0              初始化
 */
package com.wwj.springboot.springbootconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 〈描述〉<br>
 * 〈自定义ApplicationContextInitializer〉
 *
 * @author WUWJ
 * @create 2020/6/1
 * @since 1.0.0
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(MyApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LOG.info("------------自定义ApplicationContextInitializer------------");
//        applicationContext.getBean("Aodi");
    }
}
