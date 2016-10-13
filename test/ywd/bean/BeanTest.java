package ywd.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import ywd.bean.circularDependency.CircleTestA;
import ywd.bean.constructorArg.ArgBean;
import ywd.bean.custom.User;
import ywd.bean.factoryBean.Car;

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
    @Test
    public void testFactoryBean() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Car c = (Car) bf.getBean("car");
        System.out.println(c);
    }
    @Test
    public void testConstructorCircularDependency() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        CircleTestA a = (CircleTestA) bf.getBean("constructorCircleTestBeanA");
    }
    @Test
    public void testSetterCircularDependency() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        CircleTestA a = (CircleTestA) bf.getBean("setterCircleTestBeanA");
    }
    @Test
    public void testPrototypeCircularDependency() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        CircleTestA a = (CircleTestA) bf.getBean("prototypeCircleTestBeanA");
    }
}
