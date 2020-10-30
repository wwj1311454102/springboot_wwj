//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wwj.springboot.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component("captchaSupport")
public class SimpleCaptcha implements ICaptchaSupport {
    public SimpleCaptcha() {
    }

    @Override
    public boolean captchaCheck(HttpServletRequest request) {
        String answer = (String)request.getSession(true).getAttribute("simpleCaptcha");
        request.getSession().removeAttribute("simpleCaptcha");
        String checkCode = request.getParameter("checkCode");
        return answer != null && answer.equals(checkCode);
    }
}
