package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
//创建一个前置通知类
public class LogBefore implements MethodBeforeAdvice{

	//前置通知的具体内容
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("前置通知..."); 
	}

}
