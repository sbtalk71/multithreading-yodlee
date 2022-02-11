package com.demo.thread.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	public static void main(String[] args) throws Exception{
		CountDownLatch latch = new CountDownLatch(4);
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.execute(new ChildThread(500, latch));
		es.execute(new ChildThread(4000, latch));
		es.execute(new ChildThread(7000, latch));
		es.execute(new ChildThread(9000, latch));
		
		latch.await();
		
		es.shutdown();
		System.out.println("Main Thread Proceeds after Children..");

	}

}

class ChildThread implements Runnable {

	private long delay;
	private CountDownLatch latch;

	public ChildThread(long delay, CountDownLatch latch) {
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName() + " initialized..");
			latch.countDown();
			//latch.countDown();
			//latch.countDown();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
