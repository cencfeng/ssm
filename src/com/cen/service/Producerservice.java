package com.cen.service;

import javax.jms.Destination;

public interface Producerservice {

	void sendMSG(Destination destination,String msg) throws Exception;
}
