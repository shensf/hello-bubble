package com.spring.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mq {
	private static AbstractApplicationContext ctx;

	public static void main(final String... args) throws Exception {
	
		ctx = new ClassPathXmlApplicationContext("context.xml");
		RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
		template.convertAndSend("Hello, world!");
		Thread.sleep(1000);
		ctx.destroy();
	}
}

