package com.alice.java.memory;

/**
 * 关于线程安全问题
 * 火车票
 * @author alice
 *
 */
public class TicketDemo01{

	public static void main(String[] args) {
		ThreadDemo01 threadDemo01 = new ThreadDemo01();
		
		Thread thread01 = new Thread(threadDemo01);
		thread01.setName("T1");
		thread01.start();
		
		Thread thread02 = new Thread(threadDemo01);
		thread02.setName("T2");
		thread02.start();
		
		Thread thread03 = new Thread(threadDemo01);
		thread03.setName("T3");
		thread03.start();
	}
	
	
}


class ThreadDemo01 implements Runnable{

	private int count = 10;
	
	@Override
	public void run() {
		while (count > 0) {
			sale();
			count = --count;
		}
	}
	
	
	private synchronized void sale(){
		if (count > 0) {
			System.out.println(Thread.currentThread().getName() + " ==>出售火车票==>" + count);
		}
	}
	
}