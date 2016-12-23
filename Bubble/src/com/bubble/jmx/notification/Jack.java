package com.bubble.jmx.notification;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Jack extends NotificationBroadcasterSupport implements JackMBean {

	private int seq = 0;
	
	@Override
	public void hi() {
		
		Notification n = new Notification("hi jack", this, ++seq, System.currentTimeMillis(), "Jack");
		this.sendNotification(n);
	}

}
