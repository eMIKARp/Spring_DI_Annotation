package pl.myspringapp.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.myspringapp.beans.decorators.Decorator;
import pl.myspringapp.beans.decorators.Decorator.DecoratorType;
import pl.myspringapp.beans.decorators.MessageDecorator;
import pl.myspringapp.beans.producers.MessageProducer;
import pl.myspringapp.beans.producers.Producer;
import pl.myspringapp.beans.producers.Producer.ProducerType;

@Component
public class MessagePrinter {

	private MessageProducer messageProducer;
	private MessageDecorator messageDecorator;

	@Autowired
	public MessagePrinter(@Producer(type=ProducerType.SIMPLE) MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	@Autowired (required = false)
	public void setMessageDecorator(@Decorator(type=DecoratorType.UPPER) MessageDecorator messageDecorator) {
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
