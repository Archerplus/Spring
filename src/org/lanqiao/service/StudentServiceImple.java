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
			ArithmeticException.class }) // 声明为不是只读事务 设置为具有传播属性
	@Override
	public void addStudent(Student student) {
//		if(判断该学生是否存在)
		// 增加其它东西...
//		student = null;
		studentDao.addStudent(student);
//		System.out.println(1/0);	//测试异常通知
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
		System.out.println("模拟删除.....");
	}

}
