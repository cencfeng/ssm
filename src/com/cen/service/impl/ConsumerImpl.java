package com.cen.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.cen.service.Consumerservice;

@Service
public class ConsumerImpl implements Consumerservice {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public String receive(Destination destination) throws Exception {
		// TODO Auto-generated method stub
		String mes = "";
		try {
			TextMessage tm = (TextMessage) jmsTemplate.receive(destination);		
			mes += tm.getText();
				// System.out.println("从队列" + destination.toString() + "收到了消息：\t"
				// + tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}	
		return mes;
	}

}
