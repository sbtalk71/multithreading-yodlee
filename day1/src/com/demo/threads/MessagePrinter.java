package com.demo.threads;

public class MessagePrinter implements Runnable {

	private Message resource;
	private String msg;

	public MessagePrinter(Message message, String msg) {
		this.resource = message;
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			resource.printMessage(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
