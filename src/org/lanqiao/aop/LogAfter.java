package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

//创建一个后置通知类
public class LogAfter implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("后置通知" + ",方法的返回类型:" + returnValue + ",方法的名字:" + method.getName() + ",方法的参数个数:" + args.length + ",目标对象: " + target + ",返回值: " + returnValue);
	}

}
