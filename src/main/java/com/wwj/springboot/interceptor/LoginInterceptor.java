/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LogCostInterceptor
 * Author:   13114
 * Date:     2019/6/12 9:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/6/12
 * @since 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    private List<String> url = new ArrayList();


    /**
     * 开始进入地址请求拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//       List<String> uri= getUrl();
        HttpSession session = request.getSession();
        String url1 = request.getRequestURI();

//        if(uri.contains(url1)){
//            return  true;
//        }
//        if(session.getAttribute("admin") != null){
        if (session.getAttribute("admin") == null) {
            return true;
        } else {
            response.sendRedirect("/admin/login");    //未登录，跳转到登录页
            return false;
        }
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * 定义排除拦截URL
     *
     * @return
     */
    public List<String> getUrl() {
        url.add("/admin/login");      //登录页
        url.add("/admin/login/in");   //登录action URL
        url.add("/getUser");   //登录action URL
        url.add("/saveUser");   //登录action URL


        //网站静态资源
        url.add("/css/**");
        url.add("/js/**");
        url.add("/lib/**");
        url.add("/fonts/**");
        url.add("/images/**");
        return url;
    }
}
