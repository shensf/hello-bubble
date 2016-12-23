package com.bubble.jmx;

public class HelloNG implements HelloMBean{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printHello(){
		System.out.println("Hello World : "+name);
	}
	
	public void printHello(String name){
		System.out.println("HelloNG : "+name);
	}
	
}
