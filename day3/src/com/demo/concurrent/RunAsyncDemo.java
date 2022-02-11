package com.demo.concurrent;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo {

	public static void main(String[] args) throws Exception{
		
		CompletableFuture<Void> asyncResult = CompletableFuture.runAsync(()->{
			System.out.println(Thread.currentThread().getName());
		});
		
		
		asyncResult.get();

	}

}
