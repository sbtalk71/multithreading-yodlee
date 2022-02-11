package com.demo.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerWithArrayBlockingQueue {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

		new Thread(() -> {
			int i = 0;
			while (true) {
				try {
					queue.put(i++);
					System.out.println("Put : "+i);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			
			while (true) {
				try {
					Integer data=queue.take();
					System.out.println("Got : "+data);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}
