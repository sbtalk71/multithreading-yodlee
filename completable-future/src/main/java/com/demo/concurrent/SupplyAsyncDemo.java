package com.demo.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SupplyAsyncDemo {

	public static void main(String[] args) throws Exception{

		CompletableFuture<List<Emp>> asyncEmpList = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			return EmpDb.getEmpList();
		});
		
		asyncEmpList.get().stream().forEach(e->System.out.println(e.getFirstName()));
	}

}
