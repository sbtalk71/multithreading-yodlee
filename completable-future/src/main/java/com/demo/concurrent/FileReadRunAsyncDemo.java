package com.demo.concurrent;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.DataBindingException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileReadRunAsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService es = Executors.newFixedThreadPool(4);
		ObjectMapper mapper = new ObjectMapper();

		CompletableFuture<Void> asyncResult = CompletableFuture.runAsync(() -> {
			try {
				List<Emp> empList = mapper.readValue(new File("employees.json"), new TypeReference<List<Emp>>() {
				});
				System.out.println("Thread : " + Thread.currentThread().getName());
				System.out.println("No of Employees read " + empList.size());
			} catch (StreamReadException e) {
				e.printStackTrace();
			} catch (DatabindException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		},es);

		asyncResult.get();

	}

}
