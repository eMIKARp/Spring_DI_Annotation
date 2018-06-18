package pl.myspringapp.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.myspringapp.beans.decorators.Decorator.DecoratorType;

@Component
@Decorator(type=DecoratorType.LOWER)
public class LowerCaseMessageDecorator implements MessageDecorator{

	public String decorate(String msg) {
		return msg.toLowerCase();
	}

}
