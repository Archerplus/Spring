package org.lanqiao.service;

import java.sql.SQLException;

import org.lanqiao.dao.IStudentDao;
import org.lanqiao.dao.impl.StudentDaoImpl;
import org.lanqiao.entity.Student;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentServiceImple implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { SQLException.class,
			ArithmeticException.class }) // ����Ϊ����ֻ������ ����Ϊ���д�������
	@Override
	public void addStudent(Student student) {
//		if(�жϸ�ѧ���Ƿ����)
		// ������������...
//		student = null;
		studentDao.addStudent(student);
//		System.out.println(1/0);	//�����쳣֪ͨ
	}

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void deleteStudentByNo(int stuNo) {
		// TODO Auto-generated method stub
		System.out.println("ģ��ɾ��.....");
	}

}
