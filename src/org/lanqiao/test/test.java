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
	//��ԭʼ�ķ�ʽ ѧϰ�γ�
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
//		��IOC�л�ȡѧ������
		Student student = (Student)context.getBean("student");
		student.learn("htmlCourse");
	}
	public static void testDI() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course = (Course)context.getBean("course");//��Ҫ��ȡ��bean��IDֵ
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
		//��ǰ�ķ�ʽ
//		Student student = new Student();
//		student.setStuName("zs");
//		student.setStuAge(23);
//		student.setStuNo(1);
//		System.out.println(student);
		//IOC�ķ�ʽ
		//Spring�����Ķ���
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ֱ�Ӵ�SpringIOC�����л�ȡһ��idΪstudent�Ķ���
//		Student student = (Student)context.getBean("student");
//		System.out.println(student);
		//1.ʡ��new����Ĵ���
		//2.ʡ���˶������Եĸ�ֵ,���Ե�ֵ����Spring IOC��������
//		learnCourse();
		//ͨ���򵥹�������new����ķ�ʽ�������������������ά��
		//���ù���ģʽ������ֻ��Ҫ���м򵥵ĸ������־��ܽ�����Ӧ�Ĳ���
//		Student student = new Student();
//		student.learn("html");
// 		learnIoC();
//		testDI();
//		collectionDemo();
		testAop();
	}	
}
