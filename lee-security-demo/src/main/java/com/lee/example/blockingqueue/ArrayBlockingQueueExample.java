package com.lee.example.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2019-01-03 15:15
 **/
@Slf4j
public class ArrayBlockingQueueExample {
	public static void main(String[] args) throws  InterruptedException{
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
		arrayBlockingQueue.add("1");
		arrayBlockingQueue.add("2");
		arrayBlockingQueue.add("3");//加满
//		arrayBlockingQueue.clear();//清空
//		arrayBlockingQueue.add("4");//无法添加直接抛出异常
		boolean contains = arrayBlockingQueue.contains("3");
//		arrayBlockingQueue.put("4");//阻塞,直到操作成功.
//		boolean offer = arrayBlockingQueue.offer("4");//返回特定的值,true/false
//		boolean offer = arrayBlockingQueue.offer("4", 2000, TimeUnit.MILLISECONDS);//阻塞指定的时间,返回处理结果.
//		String peek = arrayBlockingQueue.peek();
//		String peek1 = arrayBlockingQueue.peek();
		String poll = arrayBlockingQueue.poll();
		String poll1 = arrayBlockingQueue.poll();
		log.info(String.valueOf(poll));
		log.info(String.valueOf(poll1));

		log.info(arrayBlockingQueue.toString());
	}
}
