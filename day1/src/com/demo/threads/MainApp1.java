package com.demo.threads;

public class MainApp1 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" Starts");
		MyThread t1 = new MyThread();
		MyThread2 t2 = new MyThread2();
		t1.setName("thread-1");
		t2.setName("thread-2");
		
		t1.start();
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(Thread.currentThread().getName()+" Ends");
		

	}

}
