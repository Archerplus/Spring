package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

//����һ������֪ͨ��
public class LogAfter implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("����֪ͨ" + ",�����ķ�������:" + returnValue + ",����������:" + method.getName() + ",�����Ĳ�������:" + args.length + ",Ŀ�����: " + target + ",����ֵ: " + returnValue);
	}

}
