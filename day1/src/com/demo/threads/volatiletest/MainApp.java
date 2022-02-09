package com.demo.threads.volatiletest;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Counter c = new Counter();
		Thread t1 = new Thread(new CounterThread(c));
		Thread t2 = new Thread(new CounterThread(c));
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
