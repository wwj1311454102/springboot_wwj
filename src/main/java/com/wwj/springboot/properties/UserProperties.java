/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserProperties
 * Author:   13114
 * Date:     2019/6/7 15:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/7
 * @since 1.0.0
 */
@Component
public class UserProperties {
    @Value("${wwj.title}")
    private String title;
    @Value("${wwj.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserProperties() {
    }


//省略getter settet方法

}

