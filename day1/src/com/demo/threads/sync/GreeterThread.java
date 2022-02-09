package com.demo.threads.sync;

public class GreeterThread implements Runnable {

	private Resource res;
	private String greetMessage;

	public GreeterThread(Resource res, String greetMessage) {
		//this.res = res;
		this.greetMessage = greetMessage;
	}

	@Override
	public void run() {
		synchronized (Resource.class) {
			Resource.printMessage(greetMessage);
			
		}
		

	}

}
