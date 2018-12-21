package com.alice.java.memory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关于线程安全问题
 * 火车票
 * @author alice
 *
 */
public class TicketDemo02{

	public static void main(String[] args) {
		ThreadDemo02 threadDemo01 = new ThreadDemo02();
		ThreadDemo02 threadDemo02 = new ThreadDemo02();
		ThreadDemo02 threadDemo03 = new ThreadDemo02();
		ThreadDemo02 threadDemo04 = new ThreadDemo02();
		ThreadDemo02 threadDemo05 = new ThreadDemo02();

		//固定大小线程池
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		
		//单任务线程池
//		ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();
		
		//可变尺寸线程池
//		ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
		
//		延迟连接池，newScheduledThreadPool
//		ExecutorService fixedThreadPool = Executors.newScheduledThreadPool(10);
		
		
		fixedThreadPool.execute(threadDemo01);
		fixedThreadPool.execute(threadDemo02);
		fixedThreadPool.execute(threadDemo03);
		fixedThreadPool.execute(threadDemo04);
		fixedThreadPool.execute(threadDemo05);
		
		fixedThreadPool.shutdown();
		
	}
	
	
}


class ThreadDemo02 implements Runnable{

	private long count = 10000000l;
	
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