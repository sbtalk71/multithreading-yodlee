package com.demo.thread.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {
		//Semaphore sem = new Semaphore(3);
		Semaphore sem=new Semaphore(1); //Mutex in java
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 1; i < 40; i++) {
			es.execute(new WorketThread(sem, 1000+(i*50)));
		}

		es.shutdown();

	}

}

class WorketThread implements Runnable {

	private Semaphore sem;
	private long delay;

	public WorketThread(Semaphore sem, long delay) {
		this.sem = sem;
		this.delay = delay;
	}

	@Override
	public void run() {
		try {
			sem.acquire();
			System.out.println(Thread.currentThread().getName() + " Aquired 1 permit");
			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName() + " finished..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sem.release();
			System.out.println(Thread.currentThread().getName() + " Released 1 permit");
		}
	}

}