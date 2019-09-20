package pvermillion.springtutorial.dependencyinjectiondemo.services;

import org.springframework.stereotype.Service;

/**
 * Created by Patrick Vermillion on 9/12/19
 */
@Service
public class GetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello - I was injected by the getter";
    }
}
