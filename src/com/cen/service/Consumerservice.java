package com.cen.service;

import javax.jms.Destination;

public interface Consumerservice {

	String receive(Destination destination) throws Exception;
}
