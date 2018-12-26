package com.lee.example;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-26 16:17
 **/
public class AtomicReferencceExample {
	private static AtomicReference<Integer> atomicReference = new AtomicReference<>(1);

	public static void main(String[] args) {
		atomicReference.compareAndSet(0, 2);
		atomicReference.compareAndSet(0, 1);
		atomicReference.compareAndSet(1, 3);
		atomicReference.compareAndSet(2, 4);
		atomicReference.compareAndSet(4, 5);
		System.out.println(atomicReference.get());
	}
}
