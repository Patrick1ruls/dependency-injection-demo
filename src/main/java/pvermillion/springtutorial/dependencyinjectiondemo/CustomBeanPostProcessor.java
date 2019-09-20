package pvermillion.springtutorial.dependencyinjectiondemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Patrick Vermillion on 9/13/19
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor { // Let's you edit the bean during the bean lifecycle

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof BeanLifeCycleDemo) {
            ((BeanLifeCycleDemo) bean).beforeInit(); // Call BeanLifeCycleDemo beans' beforeInit() method
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof BeanLifeCycleDemo) {
            ((BeanLifeCycleDemo) bean).afterInit();
        }

        return bean;
    }

}
