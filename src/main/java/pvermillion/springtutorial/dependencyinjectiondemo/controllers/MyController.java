package pvermillion.springtutorial.dependencyinjectiondemo.controllers;

import org.springframework.stereotype.Controller;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingService;

/**
 * @author patrickvermillion
 * Created: 8/6/19
 */

@Controller
public class MyController {

	private GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String hello(){
		System.out.println("Hello!!! ");

		return greetingService.sayGreeting();
	}
}
