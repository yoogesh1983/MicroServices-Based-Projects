package com.virtualpairprogrammers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor
{
	@Autowired
	private Data data;
	
	@JmsListener(destination="${microserviceApplication.queue.nameofQueue}")
	public void processPositionMessageFromQueue(Map<String, String> incomingMessage)
	{
		data.updatePosition(incomingMessage);
		//System.out.println(incomingMessage);
	}
	

}
