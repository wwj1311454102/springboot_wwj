/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: mainTest
 * Author:   13114
 * Date:     2019/6/7 20:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/7
 * @since 1.0.0
 */
public class mainTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("page_size","10");
        map.put("page_index","1");
        String  param= JSON.toJSONString(map);
        System.out.println(param);

    }
}
