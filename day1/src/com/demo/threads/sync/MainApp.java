package com.demo.threads.sync;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Resource res = new Resource();
		Thread t1 = new Thread(new GreeterThread(res, "Hello"));
		Thread t2 = new Thread(new GreeterThread(res, "Good"));
		Thread t3 = new Thread(new GreeterThread(res, "World"));

		t1.start();

		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

	}

}
