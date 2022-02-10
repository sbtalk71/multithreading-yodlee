package com.demo.fj;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class AdderListMain {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		ForkJoinPool fjp = new ForkJoinPool(5);
		for (int i = 1; i < 24; i++) {
			numList.add(i);
		}
		AddFromListTask task = new AddFromListTask(numList);
		System.out.println(fjp.invoke(task));
	}

}
