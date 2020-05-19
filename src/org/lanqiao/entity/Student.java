package org.lanqiao.entity;

import org.lanqiao.factory.CourseFactory;
import org.lanqiao.newInstance.HtmlCourse;
import org.lanqiao.newInstance.ICourse;
import org.lanqiao.newInstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Override
	public String toString() {
		return this.stuNo + "," + this.stuName + "," + this.stuAge;
	}
	public void learnJava() {
		ICourse course = new JavaCourse();
		course.learn();
	}
	public void learnHtml() {
		ICourse course = new HtmlCourse();
		course.learn();
	}
	public void learn(String name) {	//学习任何课程
		//从自己编写的简单工厂中获取
//		ICourse course = CourseFactory.getCourse(name);
		//course就是根据name拿到相应的课程
//		course.learn();
		//从SpringIoC提供的超级工厂获取
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICourse course = (ICourse)context.getBean(name);
		course.learn();
	}
}
