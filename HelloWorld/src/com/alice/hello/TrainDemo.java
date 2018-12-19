package com.alice.hello;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.omg.CORBA.OBJ_ADAPTER;

public class TrainDemo implements Runnable {

	private int count = 20;
	private boolean onOff = true;

	public static void main(String[] args) {
		// 多个线程共同抢一张票

		TrainDemo trainDemo = new TrainDemo();

		Thread thread1 = new Thread(trainDemo);
		Thread thread2 = new Thread(trainDemo);
		Thread thread3 = new Thread(trainDemo);
		Thread thread4 = new Thread(trainDemo);
		Thread thread5 = new Thread(trainDemo);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		Object object = new Object();
		LinkedList<Object> linkedList = new LinkedList<Object>();
		linkedList.add(object);
		// ExecutorService newFixedThreadPool =
		// Executors.newFixedThreadPool(10);
		// newFixedThreadPool.execute(trainDemo);

	}

	public void buyTicket() {
		// 买票
		count = --count;
		System.out.println(count);
	}

	@Override
	public void run() {
		while (count > 0) {
			buyTicket();
		}

	}

}
