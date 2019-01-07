package com.lee.example;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;



/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-26 16:26
 **/
@Getter
@Slf4j
public class AtomicExample5 {

	private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
			AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

	public volatile int count = 100;

	public static void main(String[] args) {

		AtomicExample5 example5 = new AtomicExample5();

		if (updater.compareAndSet(example5, 100, 120)) {
			log.info("update success 1, {}", example5.getCount());
		}

		if (updater.compareAndSet(example5, 100, 120)) {
			log.info("update success 2, {}", example5.getCount());
		} else {
			log.info("update failed, {}", example5.getCount());
		}
	}
}
