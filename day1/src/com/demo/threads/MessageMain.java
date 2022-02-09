package com.demo.threads;

public class MessageMain {

	public static void main(String[] args) throws Exception{
		Message message=new Message();
		Thread t1= new Thread(new MessagePrinter(message,"Hello"));
		Thread t2= new Thread(new MessagePrinter(message,"Hi"));
		Thread t3= new Thread(new MessagePrinter(message,"Bye"));

		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
	}

}
