package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {
	// 后置通知方法:JoinPoint使用于注解和Schema形式
	public void afterReturning(JoinPoint jp, Object returnValue) throws Throwable {
		System.out.println("我是Schema的后置通知" + ",方法的返回类型:" + returnValue + ",方法的名字:" + jp.getSignature().getName()
				+ ",方法的参数个数:" + jp.getArgs().length + ",目标对象: " + jp.getThis() + ",返回值: " + returnValue);
	}

	// 前置通知方法
	//
	public void before() {
		System.out.println("我是Schema的前置通知");
	}

	public void whenException(JoinPoint jp, NullPointerException e) {
		System.out.println("基于Schema的异常通知:" + e.getMessage());
	}

	public Object myAround(ProceedingJoinPoint jp) {
		Object returnValue = null;
		try {
			System.out.println("我是Schema的环绕前置通知");
			 returnValue = jp.proceed();// 执行方法,接收函数返回值
			System.out.println("我是Schema的环绕后置通知");
		} catch (Throwable e) {
			System.out.println("我是Schema的环绕异常通知");
		}
		return returnValue;
	}
}
