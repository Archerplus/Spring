package org.lanqiao.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//������ͨ��������ʵ�ֵ�
public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//������1
		Object result = null;
		try {
			//������2
			System.out.println("ͬ����֪ͨʵ�ֵ�ǰ��֪ͨ");
			result = invocation.proceed();//�����ŷ�����ִ��,���൱��ִ��addStudent()
			//invocation.proceed()֮ǰ�Ĵ���: ǰ��֪ͨ
			//result����Ŀ�귽��addStudent()�����ķ���ֵ
			//invocation.proceed()֮��Ĵ���: ����֪ͨ
			System.out.println("�û���֪ͨʵ�ֵĺ���֪ͨ");
			System.out.println("!!!!!!!!!!!Ŀ�����:" + invocation.getThis() + ",���õķ�����:" + invocation.getMethod().getName() + ",�����Ĳ�������: " + invocation.getArguments().length + "����ֵ��" + result);
		}catch(Exception ex) {
			//������3
			//�����catch����д �����쳣֪ͨ
			System.out.println("�û���֪ͨʵ�ֵ��쳣֪ͨ");
		}
		
		
		return "abc";//Ŀ�귽���ķ���ֵ
	}

}
