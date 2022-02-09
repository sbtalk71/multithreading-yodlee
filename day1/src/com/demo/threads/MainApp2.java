package com.demo.threads;

public class MainApp2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" Starts");
		
		Thread t1 = new Thread(new WorkerThread(),"worker-1");
		Thread t2 = new Thread(new WorkerThread(),"worker-2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(Thread.currentThread().getName()+" Ends");
		

	}

}
