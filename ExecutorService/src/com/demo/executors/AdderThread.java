package com.demo.executors;

import java.util.concurrent.Callable;

public class AdderThread implements Callable<Integer> {

	int a;
	int b;

	public AdderThread(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		try {
			System.out.println(Thread.currentThread().getName() + " adding " + a + " and " + b);
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		return a + b;
	}

}
