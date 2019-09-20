package pvermillion.springtutorial.dependencyinjectiondemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Patrick Vermillion on 9/13/19
 */
@Component
public class BeanLifeCycleDemo implements InitializingBean,
        DisposableBean,
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware {

    public BeanLifeCycleDemo() {
        System.out.println("## I'm in the BeanLifeCycle Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifeCycleBean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set ");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void postDestroy() {
        System.out.println("## The Pre Destroy annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println("## - After Init - Called by Bean Post Processor");
    }

}
