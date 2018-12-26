package com.lee.example;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: lee-security
 * @description: automic
 * @author: Jiliang.Lee
 * @create: 2018-12-26 15:34
 **/

public class AutomicIntegerThreadExample1 {
	private final static Integer threadTotalCount=5000;
	private final static Integer onceCount=200;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	public static void main(String[] args) throws Exception{
		CountDownLatch countDownLatch = new CountDownLatch(threadTotalCount);
		Semaphore semaphore = new Semaphore(onceCount);
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < threadTotalCount; i++) {
			executor.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
					countDownLatch.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		countDownLatch.await();
		System.out.println("共计执行次数: " + atomicInteger.get());
		executor.shutdown();
	}

	public static void add() throws Exception{
		Thread.sleep(100L);
		atomicInteger.incrementAndGet();
	}
}
