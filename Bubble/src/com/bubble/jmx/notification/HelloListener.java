package com.bubble.jmx.notification;

import javax.management.Notification;
import javax.management.NotificationListener;

import com.bubble.jmx.Hello;
import com.bubble.jmx.HelloNG;

public class HelloListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		
		System.out.println("type="+notification.getType());
		System.out.println("source="+notification.getSource());
		System.out.println("seq="+notification.getSequenceNumber());
		System.out.println("send time="+notification.getTimeStamp());
		System.out.println("message="+notification.getMessage());
		
		if(handback != null){
			if(handback instanceof Hello){
				Hello h = (Hello)handback;
				h.printHello("listener"+notification.getMessage());
			}
			if(handback instanceof HelloNG){
				HelloNG h = (HelloNG)handback;
				h.printHello("listener"+notification.getMessage());
			}
		}
		
	}

}
