package org.lanqiao.dao;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//普通类->前置通知
public class LogBefore implements MethodBeforeAdvice{

	//前置通知的具体内容
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("前置通知...");
	}
	
}
