/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   13114
 * Date:     2019/6/7 15:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.wwj.springboot.model.User;
import com.wwj.springboot.service.impl.UserServiceImpl;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/7
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Resource
    private CacheManager manager;
//    String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//    CacheManager manager=CacheManager.create("/ehcache.xml");;


    @RequestMapping("/getUser")
    public String getUser() {

        return "userinfo";

    }


    @RequestMapping("/getUser1")
    @Cacheable(value = "user-key")
    @ResponseBody
    public User getUser1() {
        User user = new User("aa", "aa@126.com", "aa123456", "aa", "123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }


    @RequestMapping("/saveUser")
//    @Cacheable(value="user-key")
    @ResponseBody
    public JSONObject saveUser(User user) {
        JSONObject jo = new JSONObject();
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        System.out.println(user);
        int i = 0;
        try {
            i = userService.saveUser(user);
        } catch (Exception e) {
            jo.put("infoMessage", e.getMessage());
        }

        String info = i == 1 ? "保存成功" : "保存失败";
        jo.put("infoMessage", info);
        return jo;
    }

    /*
     * 登录 Redis 输入 keys '*session*'
     * */
    @RequestMapping("/uid")
    @ResponseBody
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }


    @RequestMapping("/testjsp")
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView();
        //ModelAndView mv=new ModelAndView("welcome");
        mv.setViewName("welcome"); //返回的文件名
        mv.addObject("message","hello kitty");
        //类
        User user = new User();
        user.setSex("男");
        user.setUserName("nihao");
        mv.addObject("user",user);

        //List
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mv.addObject("bookList", list);

        //Map
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mv.addObject("map",map);

        return mv;

    }


    @RequestMapping("/getUserEhcache")
    @ResponseBody
    public User getUserEhcache(@RequestParam long id) {
        long cacheId=  getEhcache();
        if (cacheId!=0){
            System.out.println("ehcache不为空值为："+cacheId);
            id=cacheId;
        }
          User user= userService.selectUserById(id);
        return user;
    }

    public long getEhcache(){
        Ehcache cache = manager.getEhcache("users");

        Element e = cache.get("id");
        long id= (long) e.getObjectValue();
//        manager.shutdown();
        return id;
    }
    @RequestMapping("/setUserEhcache")
    @ResponseBody
    public String setEhcache(@RequestParam long id){
//        manager.addCache("testCache");
        Cache user = manager.getCache("users");
        user.put(new Element("id", id));
        user.flush();
//        manager.shutdown();
        return "设置成功";
    }
}
