package com.demo.threads;

public class MyThread2 extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Starts");
		try {
			for (int i = 0; i < 9; i++) {
				System.out.println(Thread.currentThread().getName() + " iteration No " + i);

				Thread.sleep(1000);
				
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" Ends");
	}
}
