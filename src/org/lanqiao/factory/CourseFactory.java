package org.lanqiao.factory;
//����һ���γ̹���

import org.lanqiao.newInstance.ICourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseFactory {
	//�������ֻ�ȡ�γ̵ķ���
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
