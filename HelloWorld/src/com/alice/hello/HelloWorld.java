package com.alice.hello;

/**
 * 睡眠排序
 * @author alice
 *
 */
public class HelloWorld implements Runnable{

	private String num;

	public HelloWorld(int num) {
		this.num = num+"";
	}

	public static void main(String[] args) {
		int[] nums = {11,2,998,5455,1,152,990};
		
		for (int i = 0; i < nums.length; i++) {
			new Thread(new HelloWorld(nums[i])).start();;
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(Integer.parseInt(num));
			System.out.println(num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
