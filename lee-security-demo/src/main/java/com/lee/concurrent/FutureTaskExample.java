package com.lee.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-28 23:15
 **/
@Slf4j
public class FutureTaskExample {

	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTask1 = new FutureTask<>(() -> {
			log.info("do somethong...");
			Thread.sleep(5000);
			return "done";
		});

		Thread thread = new Thread(futureTask1);
		thread.start();
		log.info("do somethoing in main...");

		String s = futureTask1.get();
		log.info(s);
	}
}
