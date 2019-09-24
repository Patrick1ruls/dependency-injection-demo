package pvermillion.springtutorial.dependencyinjectiondemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import pvermillion.springtutorial.dependencyinjectiondemo.examplebeans.FakeDataSource;
import pvermillion.springtutorial.dependencyinjectiondemo.examplebeans.FakeJmsBroker;

@Configuration
// @PropertySource({"classpath:datasource.properties", "classpath:jms.properties"}) // Looking in resource folder for this file
@PropertySources({ // Another way to show multiple property files
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${pv.username}")
    String user;

    @Value("${pv.password}")
    String password;

    @Value("${pv.dburl}")
    String url;

    @Value("${pv.jms.username}")
    String jmsUsername;

    @Value("${pv.jms.password}")
    String jmsPassword;

    @Value("${pv.jms.dburl}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("USERNAME")); // YOOO I CAN SET UP ENVIRONMENT VARIABLES LIKE THIS???!!!!
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUser(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
