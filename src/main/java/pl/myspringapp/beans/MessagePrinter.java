package pl.myspringapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	private MessageProducer messageProducer;
	private MessageDecorator messageDecorator;

	public MessagePrinter() {
	}
	
	@Autowired
	public MessagePrinter(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	@Autowired
	public void setMessageDecorator(MessageDecorator messageDecorator) {
		this.messageDecorator = messageDecorator;
	}
	
	public MessageDecorator getMessageDecorator() {
		return messageDecorator;
	}

	public void print() {
		String message = messageProducer.getMessage();
		message = messageDecorator != null ? messageDecorator.decorate(message):message;
		System.out.println(message);
	}	
	


	
}
