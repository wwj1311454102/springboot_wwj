/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Exam
 * Author:   13114
 * Date:     2019/10/15 21:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.tomcat;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.util.LifecycleSupport;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author 13114
 * @create 2019/10/15
 * @since 1.0.0
 */
public class Exam implements Lifecycle {

    public void init()  { System.out.println("监考老师分发考卷"); }
    public void start() { System.out.println("监考老师: 考试开始,大家可以做题了"); }
    public void stop() { System.out.println("监考老师:时间到,停止答题"); }
    public void destroy(){ System.out.println("监考老师收完卷子走人"); }

    private LifecycleSupport lifecycle=new LifecycleSupport(this);
    public void addLifecycleListener(final LifecycleListener listener) {
        lifecycle.addLifecycleListener(listener);
    }

    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }

    public void removeLifecycleListener(final LifecycleListener listener) {
        lifecycle.removeLifecycleListener(listener);
    }
    public LifecycleState getState() {
        return null;
    }
    public String getStateName() {
        return null;
    }
}
