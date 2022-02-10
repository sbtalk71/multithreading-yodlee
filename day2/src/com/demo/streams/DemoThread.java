package com.demo.streams;

public class DemoThread {

	public static void main(String[] args) {

		new Thread(() -> {

			for (int i = 0; i < 10; i++) {
				System.out.println("Thread " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}
