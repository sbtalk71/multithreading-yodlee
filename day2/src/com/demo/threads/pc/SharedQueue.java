package com.demo.threads.pc;

public class SharedQueue {
	private int data;
	volatile boolean valueSet=false;
	
	public synchronized void put(int data) {
		if(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		this.data=data; //2
		System.out.println(Thread.currentThread().getName()+" Put: "+data);
		this.valueSet=true;
		notifyAll(); //3
	}
	
	public synchronized void get() {
		if(!valueSet) {
			try {
				wait(); //1
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.valueSet=false;
		System.out.println(Thread.currentThread().getName()+" Got: "+this.data);
		notifyAll();
	}
}
