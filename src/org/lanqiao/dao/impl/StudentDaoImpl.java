package org.lanqiao.dao.impl;

import org.lanqiao.dao.IStudentDao;
import org.lanqiao.entity.Student;
import org.springframework.stereotype.Component;

//�������ioc������
@Component("studentDao")
/*
 * �൱��
 * <bean id="studentDao" class="org.lanqiao.dao.StudentDao">
 */
public class StudentDaoImpl implements IStudentDao{
	public void addStudent(Student student) {
		System.out.println("����ѧ��...");
	}
}

