package pvermillion.springtutorial.dependencyinjectiondemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingService;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingServiceImpl;


@Controller
public class PropertyInjectedController {

	@Autowired
	@Qualifier("greetingServiceImpl")
	public GreetingService greetingServiceImpl;

	public String sayHello(){
		return greetingServiceImpl.sayGreeting();
	}

}
