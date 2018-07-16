package bitcamp.pms.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.printf("MyItem => %s\n", beanName); 
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
