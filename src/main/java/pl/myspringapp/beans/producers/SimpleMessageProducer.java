package pl.myspringapp.beans.producers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.myspringapp.beans.producers.Producer.ProducerType;

@Component
@Producer(type=ProducerType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer{

	public String getMessage() {
		return "Message egzample: " + System.currentTimeMillis();
	}

}
