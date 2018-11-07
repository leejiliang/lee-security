package com.lee.test.proxy;

/**
 * @program: lee-security
 * @description: 代理类
 * @author: Jiliang.Lee
 * @create: 2018-11-06 19:10
 **/
public class Proxy implements Subject {
	private RealSubject realSubject;

	public Proxy(RealSubject subject) {
		this.realSubject = subject;
	}
	/**
	 * 静态代理,需要代理类和被代理类实现共同的接口.
	 * 可以通过调用代理类来调用被代理的实体,从而实现在不改变被代理类的情况下,扩展被代理的类的功能.
	 *
	 */
	@Override
	public void sayHello() {
		System.out.println("开启事务");
		realSubject.sayHello();
		System.out.println("关闭事务");
	}
}
