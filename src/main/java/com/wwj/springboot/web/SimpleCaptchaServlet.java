//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wwj.springboot.web;

import javax.servlet.annotation.WebServlet;
import nl.captcha.Captcha.Builder;
import nl.captcha.backgrounds.BackgroundProducer;

@WebServlet(
    urlPatterns = {"/CaptchaImg"},
    loadOnStartup = 1,
    description = "框架验证码Servlet",
    displayName = "SimpleCaptcha"
)
public class SimpleCaptchaServlet extends CheckCodeBase {
    private static final long serialVersionUID = 1L;

    public SimpleCaptchaServlet() {
    }

    @Override
    public BackgroundProducer createCodeBackground(BackgroundProducer bp) {
        return bp;
    }

    @Override
    public void createCodeImgStyle(Builder builder) {
    }
}
