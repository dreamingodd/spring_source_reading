package ywd.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestBeanTest {

    @Test
    public void test() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        TestBean bean = (TestBean) bf.getBean("testBean");
        Assert.assertEquals("Hello Spring!", bean.getTestStr());
    }
}
