package com.lee.ThreadLocal;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-25 17:33
 **/
public class UniqueSequenceGenerator {

	// 线程局部整型变量
	private static final ThreadLocal <Integer> uniqueNum =
			new ThreadLocal < Integer > () {
				@Override protected Integer initialValue() {
					return 0;
				}
			};

	//变量值
	public static int getUniqueId() {
		uniqueNum.set(uniqueNum.get() + 1);
		return uniqueNum.get();
	}

	public static void main(String[] args) {
		UniqueSequenceGenerator uniqueThreadId = new UniqueSequenceGenerator();
		// 为每个线程生成内部唯一的序列号
		TaskThread t1 = new TaskThread<UniqueSequenceGenerator>("custom-thread-1", uniqueThreadId);
		TaskThread t2 = new TaskThread<UniqueSequenceGenerator>("custom-thread-2", uniqueThreadId);
		TaskThread t3 = new TaskThread<UniqueSequenceGenerator>("custom-thread-3", uniqueThreadId);
		t1.start();
		t2.start();
		t3.start();
	}

}