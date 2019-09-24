package pvermillion.springtutorial.dependencyinjectiondemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pvermillion.springtutorial.dependencyinjectiondemo.examplebeans.FakeDataSource;
import pvermillion.springtutorial.dependencyinjectiondemo.examplebeans.FakeJmsBroker;

@Configuration
public class PropertyConfig {

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
        fakeDataSource.setUser(user);
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

}
