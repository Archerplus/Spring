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

@Component("logBeforeAnnotation") // 声明一个任意功能的注解 属性:value 值:id
@Aspect // 声明该类是一个通知
public class LogBeforeAnnotation {
	// 给任何方法加一个before注解
	// 那么这个方法就是一个前置通知的方法
	// 属性定义切点
	@Before(value = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))") // 属性:定义切点
	public void myBefore(JoinPoint jp) {
		// jp对象用来获取目标对象的一切参数
		System.out.println("注解形式-前置通知：目标对象:" + jp.getTarget() + ",获取方法名:" + jp.getSignature().getName() + ",参数列表个数:"
				+ jp.getArgs().length);
	}

	// @After是最终通知
	// @AfterReturning是后置通知
	// @AfterReturning(value = "execution(public void
	// org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	@AfterReturning(pointcut = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))", returning = "returningValue")
	public void myAfter(JoinPoint jp, Object returningValue) {
		// 方法结束后，程序自动将返回值放入Object对象中
		System.out.println("注解形式-后置通知,返回值:" + returningValue);
	}

	// 环绕通知,参数ProceedingJoinPoint
	@Around(value = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	public void myAround(ProceedingJoinPoint jp) {
		try {
			System.out.println("myAround:前置通知");
			// 方法执行之前:前置通知
			// 方法执行时
			jp.proceed();// 执行方法
			System.out.println("myAround:后置通知");
			// 方法执行之后:后置通知
		} catch (Throwable e) {
			System.out.println("myAround:异常通知");
			// 发生异常时：异常通知
		} finally {
			System.out.println("myAround:最终通知");
			// 最终通知
		}
	}

	// 异常通知
	// 注解形式的异常通知
	// 如果要捕获特定功能的异常,则可以通过第二个参数实现:e 捕获空指针异常
	@AfterThrowing(pointcut = "execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))", throwing = "e")//如果发生异常，将自动传递给e参数
	public void myException(JoinPoint jp,NullPointerException e) {
		System.out.println("注解形式:异常通知" + e.getMessage());
	}

	// 最终通知
	// 切入点表达式
	@After("execution(public void org.lanqiao.service.StudentServiceImple.addStudent(org.lanqiao.entity.Student))")
	public void myFinally() {
		System.out.println("myAround:单独的最终通知");
	}
	// @After最终通知 @AfterThrowing异常通知 @AfterReturning后置通知
}
