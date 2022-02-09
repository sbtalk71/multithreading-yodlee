package com.demo.threads.volatiletest;

public class CounterThread implements Runnable {
	Counter c;

	public CounterThread(Counter c) {

		this.c = c;
	}

	@Override
	public void run() {

		try {
			for (int i = 0; i < 20; i++) {
				int x=c.counter.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + " Counter Value " + x);
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
