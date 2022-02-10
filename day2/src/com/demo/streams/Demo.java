package com.demo.streams;

public class Demo {

	public static void main(String[] args) {

		Greeter g = new Greeter();
		g.greet(new GoodMorning());
		
		g.greet(new GreetMessage() {
			
			@Override
			public String getMessage() {
				
				return "Good Afternoon";
			}
		});
		
		g.greet(()->"Good Evening"); //()->"Good Afternoon"
		
		GreetMessage msg = ()->"Good Day";
		
		

	}

}

class GoodMorning implements GreetMessage {

	@Override
	public String getMessage() {

		return "Good Morning";
	}

}