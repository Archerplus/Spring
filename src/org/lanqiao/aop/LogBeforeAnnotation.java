package org.lanqiao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logBeforeAnnotation") // ����һ�����⹦�ܵ�ע�� ����:value ֵ:id
@Aspect // ����������һ��֪ͨ
public class LogBeforeAnnotation {
	// ���κη�����һ��beforeע��
	// ��ô�����������һ��ǰ��֪ͨ�ķ���
	// ���Զ����е�
	@Before(value = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))") // ����:�����е�
	public void myBefore(JoinPoint jp) {
		// jp����������ȡĿ������һ�в���
		System.out.println("ע����ʽ-ǰ��֪ͨ��Ŀ�����:" + jp.getTarget() + ",��ȡ������:" + jp.getSignature().getName() + ",�����б����:"
				+ jp.getArgs().length);
	}

	// @After������֪ͨ
	// @AfterReturning�Ǻ���֪ͨ
	// @AfterReturning(value = "execution(public void
	// org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	@AfterReturning(pointcut = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))", returning = "returningValue")
	public void myAfter(JoinPoint jp, Object returningValue) {
		// ���������󣬳����Զ�������ֵ����Object������
		System.out.println("ע����ʽ-����֪ͨ,����ֵ:" + returningValue);
	}

	// ����֪ͨ,����ProceedingJoinPoint
	@Around(value = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	public void myAround(ProceedingJoinPoint jp) {
		try {
			System.out.println("myAround:ǰ��֪ͨ");
			// ����ִ��֮ǰ:ǰ��֪ͨ
			// ����ִ��ʱ
			jp.proceed();// ִ�з���
			System.out.println("myAround:����֪ͨ");
			// ����ִ��֮��:����֪ͨ
		} catch (Throwable e) {
			System.out.println("myAround:�쳣֪ͨ");
			// �����쳣ʱ���쳣֪ͨ
		} finally {
			System.out.println("myAround:����֪ͨ");
			// ����֪ͨ
		}
	}

	// �쳣֪ͨ
	// ע����ʽ���쳣֪ͨ
	// ���Ҫ�����ض����ܵ��쳣,�����ͨ���ڶ�������ʵ��:e �����ָ���쳣
	@AfterThrowing(pointcut = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))", throwing = "e")//��������쳣�����Զ����ݸ�e����
	public void myException(JoinPoint jp,NullPointerException e) {
		System.out.println("ע����ʽ:�쳣֪ͨ" + e.getMessage());
	}

	// ����֪ͨ
	// �������ʽ
	@After("execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	public void myFinally() {
		System.out.println("myAround:����������֪ͨ");
	}
	// @After����֪ͨ @AfterThrowing�쳣֪ͨ @AfterReturning����֪ͨ
}
