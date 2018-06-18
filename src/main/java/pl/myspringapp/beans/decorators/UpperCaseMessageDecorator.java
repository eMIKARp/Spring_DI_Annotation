package pl.myspringapp.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.myspringapp.beans.decorators.Decorator.DecoratorType;

@Component
@Decorator(type=DecoratorType.UPPER)
public class UpperCaseMessageDecorator implements MessageDecorator{

	public String decorate(String msg) {
		return msg.toUpperCase();
	}

}
