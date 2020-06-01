/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: testConfig
 * Author:   13114
 * Date:     2019/6/10 16:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// * 〈描述〉<br>
// * 〈〉
// *
// * @author 13114
// * @create 2019/6/10
// * @since 1.0.0
public class testConfig {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ParentConfig.class);
    	 Car car =  (Car) context.getBean("aodi");
    	car.print();

		/*Reflections reflections = new Reflections("test.reflection");
		Set<Class<? extends Base>> subTypes = reflections.getSubTypesOf(Base.class);
		subTypes.forEach(x -> System.out.println(x));*/
    	}
}
