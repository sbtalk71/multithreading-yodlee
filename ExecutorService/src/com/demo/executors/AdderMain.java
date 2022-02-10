package com.demo.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class AdderMain {

	public static void main(String[] args) throws Exception {
		int sum = 0;
		// ExecutorService es = Executors.newFixedThreadPool(3);

		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		ArrayList<AdderThread> threads = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			threads.add(new AdderThread(i, i + 2));
		}

		List<Future<Integer>> results = es.invokeAll(threads);

		System.out.println("all invoked");

		do {
			for (int i = 0; i < results.size(); i++) {
				System.out.println("Processing :" + results.get(i).isDone());
			}
		} while (es.getCompletedTaskCount() < results.size());

		/*sum = results.stream().map(f -> {
			Integer res = 0;
			try {
				res = f.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}).reduce((a, b) -> a + b).get();
		*/
		for(Future<Integer> data:results) {
			sum=sum+data.get();
		}
		
		System.out.println("Sum =" + sum);
		es.shutdown();

	}

}
