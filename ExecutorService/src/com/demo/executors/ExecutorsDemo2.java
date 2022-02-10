package com.demo.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo2 {

	public static void main(String[] args) throws Exception {

		//ExecutorService es = Executors.newFixedThreadPool(5);
		ExecutorService es = Executors.newCachedThreadPool();
		// ExecutorService es = Executors.newSingleThreadExecutor();

		Future<?> futureRresult=es.submit(() -> {
				try {
					for (int i = 0; i <5; i++) {
						//System.out.println(Thread.currentThread().getName() + " is working");
						Thread.sleep(5000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});


		System.out.println("Call made ....");

		// while(!futureRresult.isDone()) {
		// System.out.println("Working...");
		// }

		// System.out.println(futureRresult.get());
		
		Thread.sleep(15000);
		futureRresult.cancel(true);
		//futureRresult.get();
		
		System.out.println("After Future.get()");
		es.shutdown();
		System.out.println("Main Thread exits..");
	}

}
