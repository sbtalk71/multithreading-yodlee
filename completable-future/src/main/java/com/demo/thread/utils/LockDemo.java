package com.demo.thread.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.execute(new LockWorker(lock));
		es.execute(new LockWorker(lock));
		es.execute(new LockWorker(lock));
		es.execute(new LockWorker(lock));
		
		es.shutdown();

	}

}

class LockWorker implements Runnable {

	private ReentrantLock lock;

	public LockWorker(ReentrantLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		int count = 0;
		while (count < 20) {
			try {
				Thread.sleep(2000);
				lock.lock();
				System.out.println("The lock count for "+tname+" " + lock.getHoldCount());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (count == 19) {
					System.out.println("Lock released by " + tname);
					lock.unlock();
				}
			}
			count++;
		}
	}
}
