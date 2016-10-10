package ywd.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import ywd.bean.constructorArg.ArgBean;
import ywd.bean.custom.User;

public class BeanTest {

    @Test
    public void testTestBean() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        TestBean bean = (TestBean) bf.getBean("testBean");
        Assert.assertEquals("Hello Spring!", bean.getTestStr());
    }
    @Test
    public void testArgBean() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        ArgBean argBean = (ArgBean) bf.getBean("argBean");

    }
    @Test
    public void testAlias() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        TestBean bean = (TestBean) bf.getBean("a1");
        Assert.assertEquals("Hello Spring!", bean.getTestStr());
    }
    @Test
    public void testCustom() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        User user = (User) bf.getBean("customBean");
        System.out.println(user.getUserName() + " - " + user.getEmail());
    }
}
