package com.demo.threads.sync;

public class Resource {

	public static void printMessage(String message) {
		System.out.print("["+message);
		try {
			Thread.sleep(1000);
			Thread.yield();
			System.out.println(Thread.currentThread().getName()+" called yield()");
			Thread.sleep(3000);
			System.out.println("]");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void fun1() {
		System.out.println("This is not locked..");
	}
}
