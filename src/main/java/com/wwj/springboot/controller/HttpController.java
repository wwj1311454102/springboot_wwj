/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HttpController
 * Author:   13114
 * Date:     2019/8/15 9:59
 * Description: http测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wwj.springboot.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈描述〉<br>
 * 〈http测试〉
 *
 * @author 13114
 * @create 2019/8/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("http")
public class HttpController {

    @RequestMapping("/test1")
    public Object testHttp1(Map inputData) {
        ResultVo vo = new ResultVo();
        String code = (String) inputData.get("id");
        vo.setCode(code);
        vo.setMessage("test1");
        vo.setData(inputData);
//        JSONObject jo= JSONObject.dsdsdsd
        return vo;
//       return  null;
    }


    @RequestMapping("/test2")
    public String testHttp2(HttpServletRequest request) {
        ResultVo vo = new ResultVo();

        InputStream inputStream = null;
        String inputData = "";
        BufferedReader bf = null;
        try {
            inputStream = request.getInputStream();

            bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bf.readLine()) != null) {
                buffer.append(line);
            }
            inputData = buffer.toString();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println("参数data:" + inputData);


        JSONObject jsonObject = JSONObject.parseObject(inputData);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("inputData");
//        System.out.println(jsonObject1.get("a"));
//        vo.getData().put("inputData",jsonObject);



        return vo.toString();
    }
}
