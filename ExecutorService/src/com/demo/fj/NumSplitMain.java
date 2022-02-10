package com.demo.fj;

import java.util.concurrent.ForkJoinPool;

public class NumSplitMain {

	public static void main(String[] args){
		
		ForkJoinPool fjp= new ForkJoinPool(5);
		NumSplitAction task=new NumSplitAction(400);
		fjp.invoke(task);

	}

}
