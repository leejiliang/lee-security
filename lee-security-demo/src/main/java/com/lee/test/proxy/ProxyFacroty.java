package com.lee.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @program: lee-security
 * @description: 动态代理对象
 * @author: Jiliang.Lee
 * @create: 2018-11-06 19:37
 **/
public class ProxyFacroty {

	//维护目标对象
	private Object target;
	public ProxyFacroty(Object target) {
		this.target = target;
	}



	public Object getProxyInstance(){
		//需要被代理类一定要实现接口
		Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
			System.out.println("动态代理执行前...");
			Object invoke = method.invoke(target, args);
			System.out.println("动态代理执行后...");

			return invoke;
		});
		return proxyInstance;
	}
}
