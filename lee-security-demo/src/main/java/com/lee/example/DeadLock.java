package com.lee.example;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: lee-security
 * @description: 死锁示例
 * @author: Jiliang.Lee
 * @create: 2018-12-27 19:01
 **/
@Slf4j
@Setter
public class DeadLock implements Runnable {
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	public DeadLock(Integer integer) {
		flag = integer;
	}

	private Integer flag;
	@Override
	public void run() {
		if (flag == 1) {
			synchronized (o1) {
				try {
					log.info("A获得锁1");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					log.info("A获得锁2");
				}
			}

		}
		if (flag == 2) {
			synchronized (o2) {
				try {
					log.info("B获得锁2");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					log.info("B获得锁1");
				}
			}

		}
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		DeadLock deadLockA = new DeadLock(1);
		DeadLock deadLockB = new DeadLock(2);
		executorService.execute(deadLockA);
		executorService.execute(deadLockB);
		executorService.shutdown();//等待线程执行完成才关闭线程池
		executorService.shutdownNow();//立即关闭线程池,不等待
	}
}
