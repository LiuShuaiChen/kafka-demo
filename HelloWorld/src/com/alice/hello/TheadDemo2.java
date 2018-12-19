package com.alice.hello;

/**
 * 守护线程
 * 设置子线程位守护线程,当主线程进入死亡状态时,其守护线程也被进入死亡状态
 * 
 * @author alice
 *
 */
public class TheadDemo2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("子线程:i==>" + i);
		}

	}

	public static void main(String[] args) {

		TheadDemo2 theadDemo2 = new TheadDemo2();
		Thread thread = new Thread(theadDemo2);
		thread.setDaemon(true);
		thread.start();
		// 设置守护线程
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("主线程==>i:" + i);
		}

	}

}
