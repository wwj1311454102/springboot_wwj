/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExamListener
 * Author:   13114
 * Date:     2019/10/15 21:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.tomcat;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author 13114
 * @create 2019/10/15
 * @since 1.0.0
 */
public class ExamListener implements LifecycleListener {

    private Exam exam;
    public ExamListener(final Exam exam) {
        this.exam = exam;
    }
    public void lifecycleEvent(final LifecycleEvent event) {
        if(event.getType().equals(Lifecycle.AFTER_INIT_EVENT)){
            exam.init();
        }else if(event.getType().equals(Lifecycle.START_EVENT)){
            exam.start();
        }else if(event.getType().equals(Lifecycle.STOP_EVENT)){
            exam.stop();
        }else if(event.getType().equals(Lifecycle.AFTER_DESTROY_EVENT)){
            exam.destroy();
            RingBell ringBell= (RingBell) event.getLifecycle();
            ringBell.setFlag(false);
        }
    }
}
