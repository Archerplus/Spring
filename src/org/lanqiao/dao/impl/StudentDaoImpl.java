package org.lanqiao.dao.impl;

import org.lanqiao.dao.IStudentDao;
import org.lanqiao.entity.Student;
import org.springframework.stereotype.Component;

//将类加入ioc容器中
@Component("studentDao")
/*
 * 相当于
 * <bean id="studentDao" class="org.lanqiao.dao.StudentDao">
 */
public class StudentDaoImpl implements IStudentDao{
	public void addStudent(Student student) {
		System.out.println("增加学生...");
	}
}

