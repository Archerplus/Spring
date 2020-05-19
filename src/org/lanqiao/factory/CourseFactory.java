package org.lanqiao.factory;
//创建一个课程工厂

import org.lanqiao.newInstance.ICourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseFactory {
	//根据名字获取课程的方法
	public static ICourse getCourse(String name) {
//		if(name.equals("java")) {
//			return new JavaCourse();
//		}else {
//			return new HtmlCourse();
//		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(name.equals("java")) {
			return (ICourse)context.getBean("javaCourse");	//new -> getBean()
		}else {
			return (ICourse)context.getBean("htmlCourse");
		}
	}
}
