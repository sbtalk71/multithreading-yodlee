package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo1 {

	public static void main(String[] args) {
		Stream.of(10).forEach(i -> System.out.println(i));
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		nums.stream().filter(a -> a % 2 == 0).forEach(System.out::println);

		int sum = nums.stream().filter(a -> !(a % 2 == 0)).mapToInt(a -> a.intValue()).sum();

		List<Integer> odds = nums.stream().filter(a -> !(a % 2 == 0)).mapToInt(n -> n.intValue() * 2)
				.mapToObj(i -> new Integer(i)).collect(Collectors.toList());

		List<String> names = Arrays.asList("Shantanu", "Nimisha", "Rose", "Ramesh", "Kirthi", "Shanti");

		// print the names of all those with a greeting message where name length is
		// more than 6 chars

		/*
		 * int sum1 = nums.stream().mapToInt(i -> i.intValue()).reduce((a,b) -> {
		 * System.out.println("adding " + a + " and " + b); return (a + b);
		 * }).getAsInt();
		 */

		int sum1 = nums.stream().mapToInt(i -> i.intValue()).reduce(2,(a, b) -> (a + b));
		System.out.println(sum1);
		
		
		  int sum2 = nums.stream().mapToInt(i -> i.intValue()).reduce(7,(a,b) -> {
		  System.out.println("adding " + a + " and " + b); return (a + b);
		  });
		  
		  nums.parallelStream().mapToInt(i -> i.intValue()).reduce(7,(a,b) -> {
			  System.out.println(Thread.currentThread().getName()); return (a + b);
			  });
		 

	}

}

/*
 * class EvenOdd implements Predicate<Integer>{
 * 
 * @Override public boolean test(Integer t) {
 * 
 * return t%2==0; }
 * 
 * }
 */