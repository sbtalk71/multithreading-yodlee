package com.demo.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class NotificationSenderAsyncCF {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();

		CompletableFuture<Void> asyncResult = CompletableFuture.supplyAsync(() -> {
			System.out.println("Get Employee List :" + Thread.currentThread().getName());
			return EmpDb.getEmpList();
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("Getting new Joiners :" + Thread.currentThread().getName());
			return employees.stream().filter(emp -> "TRUE".equals(emp.getNewJoiner())).collect(Collectors.toList());
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("Getting Learning Pending " + Thread.currentThread().getName());
			return employees.stream().filter(emp -> "TRUE".equals(emp.getLearningPending()))
					.collect(Collectors.toList());
		}, executor).thenApplyAsync((employees) -> {
			System.out.println("Getting Emails " + Thread.currentThread().getName());
			return employees.stream().map(emp -> emp.getEmail()).collect(Collectors.toList());
		}, executor).thenAcceptAsync(emailList -> emailList.stream().forEach(NotificationSenderAsyncCF::sendMail),
				executor);

		asyncResult.get();
	}

	public static void sendMail(String mailAddress) {
		System.out.println("mail sent to " + mailAddress);
	}

	public static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
