package ywd.bean.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class AwareTest implements BeanFactoryAware {
    private BeanFactory bf;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.bf = beanFactory;
    }

    public void testAware() {
        Hello h = (Hello) bf.getBean("hello");
        h.say();
    }
}
