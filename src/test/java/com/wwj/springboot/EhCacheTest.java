/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EhCacheTest
 * Author:   13114
 * Date:     2019/11/6 15:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot;

import com.wwj.springboot.model.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Map;
import java.util.Properties;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author 13114
 * @create 2019/11/6
 * @since 1.0.0
 */
public class EhCacheTest {
    public static void main(String[] args) {
        System.out.println("----------env----------------");
         Map map= System.getenv();
        for (Object key : map.keySet()) {
            System.out.println(key + " : " + map.get((String) key));
        }
        System.out.println("----------properties----------------");
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            System.out.println(key + " : " + properties.getProperty((String) key));
        }
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("D:\\workSpace\\MyworkSpace\\springboot_wwj\\src\\main\\resources\\ehcache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("users");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        User user = new User("u1", "aa@126.com", "aa123456", "aa", "123");
        Element element2 = new Element("u1", user);
        cache.put(element2);
        Element u1 = cache.get("u1");
        User user1 = (User) u1.getObjectValue();
        System.out.println(user1.toString());

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }

}
