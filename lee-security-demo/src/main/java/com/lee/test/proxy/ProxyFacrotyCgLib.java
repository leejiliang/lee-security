package com.lee.test.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: lee-security
 * @description: 动态代理对象
 * @author: Jiliang.Lee
 * @create: 2018-11-06 19:37
 **/
public class ProxyFacrotyCgLib implements MethodInterceptor {

	//维护目标对象
	private Object target;
	public ProxyFacrotyCgLib(Object target) {
		this.target = target;
	}



	public Object getProxyInstance(){
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("cgLibBefore...");
		method.invoke(target, objects);
		System.out.println("cgLibAfter...");
		return null;
	}
}
