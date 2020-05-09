/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RingBell
 * Author:   13114
 * Date:     2019/10/15 21:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.tomcat;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.util.LifecycleSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈描述〉<br> 
 * 〈〉
 *
 * @author 13114
 * @create 2019/10/15
 * @since 1.0.0
 */
public class RingBell implements Lifecycle {

    private boolean flag=true;
    public void setFlag(final boolean flag) {
        this.flag = flag;
    }

    private LifecycleSupport lifecycle=new LifecycleSupport(this);
    public void addLifecycleListener(final LifecycleListener listener) {
        lifecycle.addLifecycleListener(listener);
    }
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }
    public void removeLifecycleListener(final LifecycleListener listener) {lifecycle.removeLifecycleListener(listener); }
    public void start() throws LifecycleException { }
    public void stop() throws LifecycleException { }
    public void destroy() throws LifecycleException {}
    public LifecycleState getState() { return null; }
    public String getStateName() { return null; }

    public void init() throws LifecycleException {
        System.out.println("时钟慢慢走动.....");
        while(flag){
            Date now = new Date();
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(now));
            if(now.getHours()==11 && now.getMinutes()== 25 && now.getSeconds()==0){
                lifecycle.fireLifecycleEvent(Lifecycle.AFTER_INIT_EVENT,null);
            }else if(now.getHours()==11 && now.getMinutes()== 25  && now.getSeconds()== 2){
                lifecycle.fireLifecycleEvent(Lifecycle.START_EVENT,null);
            }else if(now.getHours()==11 && now.getMinutes()== 25 && now.getSeconds()==4){
                lifecycle.fireLifecycleEvent(Lifecycle.STOP_EVENT,null);
            }else if(now.getHours()==11 && now.getMinutes()== 25  && now.getSeconds()== 6){
                lifecycle.fireLifecycleEvent(Lifecycle.AFTER_DESTROY_EVENT,null);
            }else if(now.getHours()==11 && now.getMinutes()== 25  && now.getSeconds()== 8){
                lifecycle.fireLifecycleEvent(Lifecycle.AFTER_DESTROY_EVENT,null);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("谁把时钟关了");
    }

}
