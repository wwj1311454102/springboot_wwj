/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyBatisConfig
 * Author:   13114
 * Date:     2019/6/12 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/12
 * @since 1.0.0
 */
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager();
    }
}
