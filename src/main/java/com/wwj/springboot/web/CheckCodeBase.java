//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wwj.springboot.web;


import java.awt.Color;
import java.awt.Font;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.captcha.Captcha;
import nl.captcha.Captcha.Builder;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.backgrounds.SquigglesBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;
import nl.captcha.text.renderer.WordRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CheckCodeBase extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(CheckCodeBase.class);
    private static final int WIDTH = 150;
    private static final int HEIGHT = 50;
    private static final String elements = "23456789abcdefgjkmxyzpqr";
    private final SecureRandom random = new SecureRandom();

    public CheckCodeBase() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (logger.isWarnEnabled()) {
            logger.warn("进入验证码..............................................................");
        }
        String a = req.getParameter("a");
//        CaptchaConfig simpleCaptchaConfig = (CaptchaConfig)ServiceLocator.getService("captchaConfig");
//        int checkCode = simpleCaptchaConfig.getNumberCheckCodeLevel();
        int checkCode = Integer.valueOf(a) ;
        if (logger.isWarnEnabled()) {
            logger.warn("获取配置");
        }

        Builder builder = new Builder(150, 50);
        if (logger.isWarnEnabled()) {
            logger.warn("创建img");
        }

        List<Font> fontList = new ArrayList();
        fontList.add(new Font("Microsoft YaHei UI", 1, 40));
        fontList.add(new Font("Arial", 2, 40));
        if (logger.isWarnEnabled()) {
            logger.warn("设置字体");
        }

        int r = this.random.nextInt(255);
        int g = this.random.nextInt(255);
        int b = this.random.nextInt(255);
        if (logger.isWarnEnabled()) {
            logger.warn("生成随机数");
        }

        WordRenderer wr = new DefaultWordRenderer(new Color(r, g, b), fontList);
        if (logger.isWarnEnabled()) {
            logger.warn("创建WordRenderer");
        }

        char[] chars = "23456789".toCharArray();
        Object bp;
        switch(checkCode) {
        case 2:
            bp = new GradiatedBackgroundProducer();
            builder.addNoise();
            break;
        case 3:
            chars = "23456789abcdefgjkmxyzpqr".toCharArray();
            bp = new GradiatedBackgroundProducer();
            break;
        case 4:
            chars = "23456789abcdefgjkmxyzpqr".toCharArray();
            builder.addNoise();
            bp = new GradiatedBackgroundProducer();
            ((GradiatedBackgroundProducer)bp).setFromColor(Color.black);
            ((GradiatedBackgroundProducer)bp).setToColor(Color.white);
            break;
        case 5:
            chars = "23456789abcdefgjkmxyzpqr".toCharArray();
            bp = new SquigglesBackgroundProducer();
            break;
        case 6:
            builder.addNoise();
            chars = "23456789abcdefgjkmxyzpqr".toCharArray();
            bp = new SquigglesBackgroundProducer();
            break;
        default:
            bp = new FlatColorBackgroundProducer(Color.white);
        }

        BackgroundProducer bp1 = this.createCodeBackground((BackgroundProducer)bp);
        if (logger.isWarnEnabled()) {
            logger.warn("创建bp");
        }

        builder.addText(new DefaultTextProducer(checkCode / 2 + 3, chars), wr);
        builder.addBackground(bp1);
        this.createCodeImgStyle(builder);
        Captcha captcha = builder.build();
        if (logger.isWarnEnabled()) {
            logger.warn("创建验证码");
        }

        req.getSession().setAttribute("simpleCaptcha", captcha.getAnswer());
        if (logger.isWarnEnabled()) {
            logger.warn("准备输出..............................................................");
        }

        CaptchaServletUtil.writeImage(resp, captcha.getImage());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }

    public abstract BackgroundProducer createCodeBackground(BackgroundProducer bp);

    public abstract void createCodeImgStyle(Builder builder);
}
