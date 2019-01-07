package com.lee.example.executor;

public class PrintABC implements Runnable{

	private String name;
	private int id;

	private static int  count=0;
	public PrintABC(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public static final Object obj=new Object();
	@Override
	public void run() {
		synchronized (obj) {
			while(count<30){
				if(count % 3==id){
					System.out.println(name+":  "+count);
					count++;
					Thread currentThread = Thread.currentThread();
					obj.notifyAll();
				}else{
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Thread(new PrintABC("A",0)).start();
		new Thread(new PrintABC("B",1)).start();
		new Thread(new PrintABC("C",2)).start();
		//System.out.println(2%3);
	}
}
