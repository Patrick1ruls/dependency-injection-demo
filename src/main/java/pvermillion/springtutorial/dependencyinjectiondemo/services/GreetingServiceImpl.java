package pvermillion.springtutorial.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

/**
 * Created by Patrick Vermillion
 */
@Service
public class GreetingServiceImpl implements GreetingService {
	
	public static final String HELLO_GURUS = "Hello Gurus!!!! - Original";
	
	@Override
	public String sayGreeting() {
		return HELLO_GURUS;
	}
		
}
	

