package com.demo.fj;

import java.util.concurrent.RecursiveAction;

public class NumSplitAction extends RecursiveAction {

	private double data;

	public NumSplitAction(double data) {
		this.data = data;
	}

	@Override
	protected void compute() {
		if (data > 10) {
			System.out.println(Thread.currentThread().getName());
			NumSplitAction t1 = new NumSplitAction(data / 2);
			NumSplitAction t2 = new NumSplitAction(data / 2);
			t1.fork();
			t2.fork();
			
			t1.join();
			t2.join();
		} else {
			System.out.println("Split Data = " + data);
		}

	}

}
