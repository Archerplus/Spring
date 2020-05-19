package org.lanqiao.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//本质是通过拦截器实现的
public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//方法体1
		Object result = null;
		try {
			//方法体2
			System.out.println("同环绕通知实现的前置通知");
			result = invocation.proceed();//控制着方法的执行,就相当于执行addStudent()
			//invocation.proceed()之前的代码: 前置通知
			//result就是目标方法addStudent()方法的返回值
			//invocation.proceed()之后的代码: 后置通知
			System.out.println("用环绕通知实现的后置通知");
			System.out.println("!!!!!!!!!!!目标对象:" + invocation.getThis() + ",调用的方法名:" + invocation.getMethod().getName() + ",方法的参数个数: " + invocation.getArguments().length + "返回值：" + result);
		}catch(Exception ex) {
			//方法体3
			//如果在catch里面写 就是异常通知
			System.out.println("用环绕通知实现的异常通知");
		}
		
		
		return "abc";//目标方法的返回值
	}

}
