package com.bubble.hello;

public class First {
	
	public static void main(String[] args) {
		
		CallTest ct = new CallTest();
		ct.sayHi(new Call() {
			
			@Override
			public void callback() {
				System.out.println("I am back");
				
			}
		});
	}

}
