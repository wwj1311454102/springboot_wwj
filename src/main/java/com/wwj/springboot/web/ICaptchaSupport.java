//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wwj.springboot.web;

import javax.servlet.http.HttpServletRequest;

public interface ICaptchaSupport {
    String CHECKCODE_KEY = "simpleCaptcha";
    String CHECKCODE_TYPE_SIMPLE = "simple";
    String CHECKCODE_TYPE_SLIDE = "slide";
    String SLIDE_CHECKCODE_KEY_PARAM = "slideCheckCodeKeyParam";
    String SLIDE_CHECKCODE_KEY_TICKET = "slideCheckCodeKeyTicket";
    String SLIDE_CHECKCODE_KEY_RESULT = "slideCheckCodeVerifyResult";
    String PW_VALIDATION_ERROR_NUMBER = "passwordValidationErrorNumber";

    boolean captchaCheck(HttpServletRequest request);
}
