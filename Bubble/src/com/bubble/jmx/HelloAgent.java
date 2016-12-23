package com.bubble.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.bubble.jmx.notification.HelloListener;
import com.bubble.jmx.notification.Jack;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {

	public static void main(String[] args) throws Exception {
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
		Hello hello = new Hello();
		server.registerMBean(hello, helloName);
		
		server.registerMBean(new Hello(), new ObjectName("chengang:name=HelloWorld2"));
		
		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8080");
		HtmlAdaptorServer ad = new HtmlAdaptorServer();
		server.registerMBean(ad, adapterName);
		
		//notification begin
		Jack jack = new Jack();
		server.registerMBean(jack, new ObjectName("HelloAgent:name=jack"));
		jack.addNotificationListener(new HelloListener(), null, hello);
		//jack.addNotificationListener(new HelloListener(), null, new HelloNG());
		//notification end
		
		ad.start();
		System.out.println("start....");
	}
}
