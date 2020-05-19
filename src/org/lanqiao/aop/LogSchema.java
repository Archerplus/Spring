package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {
	// ����֪ͨ����:JoinPointʹ����ע���Schema��ʽ
	public void afterReturning(JoinPoint jp, Object returnValue) throws Throwable {
		System.out.println("����Schema�ĺ���֪ͨ" + ",�����ķ�������:" + returnValue + ",����������:" + jp.getSignature().getName()
				+ ",�����Ĳ�������:" + jp.getArgs().length + ",Ŀ�����: " + jp.getThis() + ",����ֵ: " + returnValue);
	}

	// ǰ��֪ͨ����
	//
	public void before() {
		System.out.println("����Schema��ǰ��֪ͨ");
	}

	public void whenException(JoinPoint jp, NullPointerException e) {
		System.out.println("����Schema���쳣֪ͨ:" + e.getMessage());
	}

	public Object myAround(ProceedingJoinPoint jp) {
		Object returnValue = null;
		try {
			System.out.println("����Schema�Ļ���ǰ��֪ͨ");
			 returnValue = jp.proceed();// ִ�з���,���պ�������ֵ
			System.out.println("����Schema�Ļ��ƺ���֪ͨ");
		} catch (Throwable e) {
			System.out.println("����Schema�Ļ����쳣֪ͨ");
		}
		return returnValue;
	}
}
