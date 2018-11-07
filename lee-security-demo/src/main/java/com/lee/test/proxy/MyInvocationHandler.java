package com.lee.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: lee-security
 * @description: myselfInvocationHandler
 * @author: Jiliang.Lee
 * @create: 2018-11-06 20:04
 **/
public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始");
		Object invoke = method.invoke(target, args);
		System.out.println("结束");
		return invoke;
	}
}
