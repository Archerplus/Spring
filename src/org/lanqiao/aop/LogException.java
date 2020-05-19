package org.lanqiao.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

//����һ���쳣֪ͨ��
public class LogException implements ThrowsAdvice {
	// �쳣֪ͨ�ľ��巽��
	// ����д�������
	public void afterThrowing(Method method, Object[] args, Object target, Throwable ex) {
		System.out.println("�쳣֪ͨ:Ŀ�����;" + target + ",������:" + method.getName() + ",��������:" + args.length + ",�쳣����:"
				+ ex.getMessage());
	}
}
