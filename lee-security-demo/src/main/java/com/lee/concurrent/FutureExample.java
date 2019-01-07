package com.lee.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-28 23:15
 **/
@Slf4j
public class FutureExample {
	public static class MyCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			log.info("do somethong...");
			Thread.sleep(5000);
			return "done";
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> future = executorService.submit(new MyCallable());
		log.info("do something in main...");
		Thread.sleep(1000);
		String s = future.get();
		log.info(s);
	}
}
