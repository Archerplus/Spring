package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//����һ��ǰ��֪ͨ��
public class LogBefore implements MethodBeforeAdvice{

	//ǰ��֪ͨ�ľ�������
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ǰ��֪ͨ..."); 
	}

}
