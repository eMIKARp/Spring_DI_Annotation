package pl.myspringapp.beans.producers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.myspringapp.beans.producers.Producer.ProducerType;

@Component
@Producer(type=ProducerType.FILE)
public class FileMessageProducer implements MessageProducer{

	public String getMessage() {
		
		List<String> lines = null;
		try {
			Path path = new File(getClass().getResource("/message.txt").toURI()).toPath();
			lines = Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		String result="";
		if (lines!=null)
			result = lines.stream().reduce(result, (a,b)->a+b);
		
		return null;
	}

}
