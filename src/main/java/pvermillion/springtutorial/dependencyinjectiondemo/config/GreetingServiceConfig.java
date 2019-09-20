package pvermillion.springtutorial.dependencyinjectiondemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingRepository;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingService;
import pvermillion.springtutorial.dependencyinjectiondemo.services.GreetingServiceFactory;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository repository) {
        return new GreetingServiceFactory(repository);
    }

    @Bean
    @Primary
    @Profile({"default", "english"}) // en
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("english");
    }

    @Bean
    @Primary
    @Profile("spanish") // es
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("spanish");
    }

    @Bean
    @Primary
    @Profile("german") // de
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("german");
    }
}
