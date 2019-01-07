package com.lee.test.proxy;

/**
 * @program: lee-security
 * @description: 未实现任何接口的业务类
 * @author: Jiliang.Lee
 * @create: 2018-11-06 20:26
 **/
public class RealSubjectWithOutInterface {
	public void sayHello() {
		System.out.println("hello...cgLib");
	}
}
