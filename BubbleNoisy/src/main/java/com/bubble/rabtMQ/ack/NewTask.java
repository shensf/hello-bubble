package com.bubble.rabtMQ.ack;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.MessageProperties;  
  
public class NewTask  
{  
    // ��������  
    private final static String QUEUE_NAME = "workqueue_persistence";  
  
    public static void main(String[] args) throws IOException, TimeoutException  
    {  
        // �������Ӻ�Ƶ��  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        // ��������  
        boolean durable = true;// 1�����ö��г־û�  
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);  
        // ����10����Ϣ����������Ϣ���渽��1-10����  
        for (int i = 5; i > 0; i--)  
        {  
            String dots = "";  
            for (int j = 0; j <= i; j++)  
            {  
                dots += ".";  
            }  
            String message = "helloworld" + dots + dots.length();  
            // MessageProperties 2��������Ϣ�־û�  
            channel.basicPublish("", QUEUE_NAME,  
                    MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());  
            System.out.println(" [x] Sent '" + message + "'");  
        }  
        // �ر�Ƶ������Դ  
        channel.close();  
        connection.close();  
  
    }  
  
} 