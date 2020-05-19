package org.lanqiao.test;

import org.lanqiao.entity.AllCollectionType;
import org.lanqiao.entity.Course;
import org.lanqiao.entity.Student;
import org.lanqiao.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
public class test {
	private static Object bean;
	//最原始的方式 学习课程
	public static void learnCourse() {
		Student student = new Student();
		student.learnHtml();
		student.learnJava();
	}
	public static void learnCourseWithFactory() {
		Student student = new Student();
	}
	public static void learnIoC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		从IOC中获取学生对象
		Student student = (Student)context.getBean("student");
		student.learn("htmlCourse");
	}
	public static void testDI() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course = (Course)context.getBean("course");//需要获取的bean的ID值
		course.showInfo();
	}
	public static void collectionDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AllCollectionType type = (AllCollectionType)context.getBean("collectionDemo");
		System.out.println(type);
	}
	//error
	public static void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService)context.getBean("studentServiceImpl");
		Student student = new Student();
		student.setStuAge(233);
		student.setStuName("zs");
		student.setStuNo(45);
		System.out.println("hello");
		studentService.addStudent(student);
//		studentService.deleteStudentByNo(10);
		System.out.println("world");
	}
	public static void main(String[] args) {
		//以前的方式
//		Student student = new Student();
//		student.setStuName("zs");
//		student.setStuAge(23);
//		student.setStuNo(1);
//		System.out.println(student);
		//IOC的方式
		//Spring上下文对象
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//直接从SpringIOC容器中获取一个id为student的对象
//		Student student = (Student)context.getBean("student");
//		System.out.println(student);
		//1.省略new对象的创建
		//2.省略了对象属性的赋值,属性的值放在Spring IOC容器中了
//		learnCourse();
		//通过简单工厂，将new对象的方式集中了起来，方便后期维护
		//利用工厂模式，我们只需要进行简单的更改名字就能进行相应的操作
//		Student student = new Student();
//		student.learn("html");
// 		learnIoC();
//		testDI();
//		collectionDemo();
		testAop();
	}	
}
