package com.demo.threads.pc;

public class PCMain {

	public static void main(String[] args) throws Exception {
		SharedQueue queue = new SharedQueue();
		Thread producer = new Thread(new Producer(queue), "producer");
		Thread consumer = new Thread(new Consumer(queue), "consumer1");
		Thread consumer1 = new Thread(new Consumer(queue), "consumer2");

		producer.start();
		consumer.start();
		consumer1.start();

		producer.join();
		consumer.join();
		consumer1.join();

	}

}
