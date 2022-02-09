package com.demo.threads;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println("App stared..");
		System.out.println(Thread.currentThread());
		System.out.println("Thread : "+Thread.currentThread().getName());
		Thread.currentThread().setName("MyThread-1");
		Thread.currentThread().setPriority(8);
		System.out.println(Thread.currentThread());

	}

}
