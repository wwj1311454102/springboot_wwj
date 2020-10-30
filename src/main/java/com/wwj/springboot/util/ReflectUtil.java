package com.wwj.springboot.util;

import com.wwj.springboot.dto.Student;
import com.wwj.springboot.dto.Teacher;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
 
public class ReflectUtil {
	public static  <T> T  getMethodField(Object instance, Class<T> clazz) throws IllegalAccessException, NoSuchFieldException {
        String  fieldName =clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1);
//      Field field0=  instance.getClass().getField(fieldName);
      Field field0=  instance.getClass().getDeclaredField(fieldName);
		Field field = getField(instance.getClass(), fieldName);
		// 参数值为true，禁用访问控制检查
		field.setAccessible(true);
        Object o =field.get(instance);
        if(clazz.isInstance(o)){
            return clazz.cast(o);
        }
		return null;
	}
 
	public static Field getField(Class thisClass, String fieldName) throws NoSuchFieldException {
		if (fieldName == null) {
			throw new NoSuchFieldException("Error field !");
		}
		
		// 绑定当前类、及父类所有属性合并
		List<Field> fieldList = new ArrayList<Field>();
		
		// 获取当前实体类的所有属性（不包含继承的类的属性），返回Field数组
		Field[] fieldChi = thisClass.getDeclaredFields();
		fieldList.addAll(Arrays.asList(fieldChi));
		
		// 获取该实体类父类所有属性
		Field[] fieldParent = thisClass.getSuperclass().getDeclaredFields();
		fieldList.addAll(Arrays.asList(fieldParent));
		
		// 返回相应字段属性值
		for(Field item : fieldList){
			if(item.getName().equals(fieldName)){
				return item; //子类存在则直接返回
			}
		}
		//Field field = thisClass.getDeclaredField(fieldName);
		return null;
	}
 
	/**
	 * 指定成员赋值
	 * @param model
	 * @param fieldName
	 * @param fieldValue
	 */
	public static void setModelValue(Object model, String fieldName, String fieldValue) {
		// 获取当前实体类的所有属性（不包含继承的类的属性），返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		// 获取该实体类父类所有属性
		Field[] fieldParent = model.getClass().getSuperclass().getDeclaredFields();
		if(fieldParent.length > 0){
			field = fieldParent;
		}
        try {
            for (int j = 0; j < field.length; j++) { // 遍历所有属性
                String name = field[j].getName(); // 获取属性的名字
                if (name.equalsIgnoreCase(fieldName)){
                    name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    String type = field[j].getGenericType().toString(); // 获取属性的类型
                    if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                        Method m = model.getClass().getMethod("get" + name);
                        String value = (String) m.invoke(model); // 调用getter方法获取属性值
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,String.class);
                            m.invoke(model, fieldValue);
                        }
                    }
                    if (type.equals("class java.lang.Integer")) {
                        Method m = model.getClass().getMethod("get" + name);
                        Integer value = (Integer) m.invoke(model);
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,Integer.class);
                            m.invoke(model, Integer.parseInt(fieldValue));
                        }
                    }
                    if (type.equals("class java.lang.Boolean")) {
                        Method m = model.getClass().getMethod("get" + name);
                        Boolean value = (Boolean) m.invoke(model);
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,Boolean.class);
                            m.invoke(model, Boolean.parseBoolean(fieldValue));
                        }
                    }
                    if (type.equals("class java.util.Date")) {
                        Method m = model.getClass().getMethod("get" + name);
                        Date value = (Date) m.invoke(model);
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,Date.class);
                        /*    if (fieldValue.length() > 10){
                                m.invoke(model, DateUtil.fomatTime(fieldValue));
                            }else{
                                m.invoke(model, DateUtil.fomatDate(fieldValue));
                            }*/
                        }
                    }
                    if (type.equals("class java.lang.Short")) {
                        Method m = model.getClass().getMethod("get" + name);
                        Date value = (Date) m.invoke(model);
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,Short.class);
                            m.invoke(model, Short.parseShort(fieldValue));
                        }
                    }
                    if (type.equals("class java.lang.Long")) {
                        Method m = model.getClass().getMethod("get" + name);
                        Date value = (Date) m.invoke(model);
                        if (value == null) {
                            m = model.getClass().getMethod("set"+name,Long.class);
                            m.invoke(model, Long.parseLong(fieldValue));
                        }
                    }                     
                }
            }
        }catch(Exception ex){
        	System.out.println(ex);
        }
	}

	public static void main(String[] args) {

	    Object date = new Date();
	    System.out.println(Date.class.cast(date));


        Teacher teacher = new Teacher();
        teacher.setId("id");
        teacher.setName("name");

        Student student = new Student();
        student.setName("111");
        student.setTeacher(teacher);

        try {
       Class clazz=  student.getClass();
        Field[] fields = clazz.getDeclaredFields();// 压制了访问控制权限情况下，获取所有的成员变量
        // //遍历输出
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        String firstLetter = "teacher".substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + "teacher".substring(1);
        Method method = student.getClass().getMethod(getter, new Class[] {});
        Object value = method.invoke(student, new Object[] {});

            Teacher teacher1 = ReflectUtil.getMethodField(student, Teacher.class);
            System.out.println(teacher1);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException  | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
