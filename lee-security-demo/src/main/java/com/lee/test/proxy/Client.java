package com.lee.test.proxy;

import sun.jvm.hotspot.HelloWorld;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @program: lee-security
 * @description: testProxy
 * @author: Jiliang.Lee
 * @create: 2018-11-06 19:12
 **/
public class Client {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException ,InstantiationException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException

	{

		/**
		 * 静态代理
		 */
//		RealSubject realSubject = new RealSubject();
//		Proxy proxy = new Proxy(realSubject);
//		proxy.sayHello();

//		/**
//		 * 动态代理  接口代理
//		 */
//		Subject realSubject = new RealSubject();
//		ProxyFacroty proxyFacroty = new ProxyFacroty(realSubject);
//		Subject proxyInstance = (Subject)proxyFacroty.getProxyInstance();
//		proxyInstance.sayHello();

		Class<?> proxyClass= Proxy.getProxyClass(Client.class.getClassLoader(), Subject.class);
		final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
		final InvocationHandler ih = new MyInvocationHandler(new RealSubject());
		Subject realSubject= (Subject)cons.newInstance(ih);
		realSubject.sayHello();



		RealSubjectWithOutInterface realSubject1 = new RealSubjectWithOutInterface();
		ProxyFacrotyCgLib proxyFacrotyCgLib = new ProxyFacrotyCgLib(realSubject1);
		RealSubjectWithOutInterface proxyInstance1 = (RealSubjectWithOutInterface)proxyFacrotyCgLib.getProxyInstance();
		proxyInstance1.sayHello();


	}
}
