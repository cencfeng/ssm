package com.cen.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.cen.service.Producerservice;
@Service
public class ProducerImpl implements Producerservice {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Override
	public void sendMSG(Destination destination,String msg) throws Exception {
		// TODO Auto-generated method stub
		        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
		        jmsTemplate.send(destination, new MessageCreator() {
		            public Message createMessage(Session session) throws JMSException {
		                return session.createTextMessage(msg);
		            }
		        });
		    }

}
