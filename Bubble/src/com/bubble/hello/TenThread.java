package com.bubble.hello;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.management.loading.ClassLoaderRepository;

public class TenThread implements Runnable{
	
	String name;
	
	private TenThread(String name){
		this.name = name;
	}
	
	public static void main(String[] args) {
		//ExecutorService es = Executors.newFixedThreadPool(10);
		//repeat(10, new TenThread("hi fuck"), es);
		System.out.println(System.getProperty("line.separator"));
		
	}
	
	public static void repeat(int n, Runnable action,ExecutorService es){
        for (int i = 0; i < n; i++) {
        	es.submit(action);
        }
    }

	@Override
	public void run() {
		System.out.println("I am the thread:"+name);
	}
	
}
