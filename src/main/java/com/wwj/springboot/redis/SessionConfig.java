/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SessionConfig
 * Author:   13114
 * Date:     2019/6/9 13:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 〈描述〉<br>
 * 〈〉
 * ，默认采用外置的 Redis 来存储 Session 数据，以此来解决 Session 共享的问题
 *
 * @author 13114
 * @create 2019/6/9
 * @since 1.0.0
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
}
