package com.lee.test.proxy;

/**
 * @program: lee-security
 * @description: 被代理实体
 * @author: Jiliang.Lee
 * @create: 2018-11-06 19:11
 **/
public class RealSubject implements Subject {
	@Override
	public final void sayHello() {
		System.out.println(RealSubject.class.getName()+"...");
	}
}
