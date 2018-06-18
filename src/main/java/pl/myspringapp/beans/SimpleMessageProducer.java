package pl.myspringapp.beans;

import org.springframework.stereotype.Component;

@Component
public class SimpleMessageProducer implements MessageProducer{

	public String getMessage() {
		return "Message egzample: " + System.currentTimeMillis();
	}

}
