/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Test
 * Author:   13114
 * Date:     2019/10/15 21:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.tomcat;

import org.apache.catalina.LifecycleException;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author 13114
 * @create 2019/10/15
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws LifecycleException {
        Exam exam = new Exam();
        RingBell ringBell=new RingBell();
        ringBell.addLifecycleListener(new ExamListener(exam));
        ringBell.init();
//        Bootstrap;
    }
}
