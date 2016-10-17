package ywd.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ContextTest {
    @Test
    public void simpleTest() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beans.xml");
    }
    @Test
    public void beanFactoryPostProcessorTest() {
        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfppBean");
        bfpp.postProcessBeanFactory(bf);
        System.out.println(bf.getBean("bfppTestBean"));
        // »ò
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(ac.getBean("bfppTestBean"));
    }
}
