package com.demo.threads;

public class Message {

	public void printMessage(String message) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " Starts");
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(Thread.currentThread().getName()+" printing " + message+" : " + i);

				Thread.sleep(1000);

			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " Ends");
	}

}
