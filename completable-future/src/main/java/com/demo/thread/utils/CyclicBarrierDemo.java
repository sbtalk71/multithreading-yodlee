package com.demo.thread.utils;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	public static void main(String[] args) throws Exception{

		CyclicBarrier barrier = new CyclicBarrier(4);
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.execute(new Task(barrier,2000));
		es.execute(new Task(barrier,4000));
		es.execute(new Task(barrier,6000));
		es.execute(new Task(barrier,8000));
		//es.execute(new Task(barrier,10000));

		es.shutdown();
		System.out.println(" Main thread done..");
	}

}

class Task implements Runnable {

	private CyclicBarrier barrier;
	private long delay;

	public Task(CyclicBarrier barrier, long delay) {
		this.barrier = barrier;
		this.delay = delay;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(delay);
				System.out.println(Thread.currentThread().getName()+" job done, breaking the barrier");
				System.out.println("waiting to reach barrier "+barrier.getNumberWaiting());
				barrier.await();
				System.out.println("Message sent from " + Thread.currentThread().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}