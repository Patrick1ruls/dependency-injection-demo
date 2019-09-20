package pvermillion.springtutorial.dependencyinjectiondemo.services;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {

        switch (lang){
            case "english":
                return new PrimaryGreetingService(greetingRepository);
            case "german":
                return new PrimaryGermanGreetingService(greetingRepository);
            case "spanish":
                return new PrimarySpanishGreetingService(greetingRepository);
            default:
                return new PrimaryGreetingService(greetingRepository);
        }

    }
}
