package ywd.bean.postProcessor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> obscenities;
    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenities = new HashSet<String>();
    }

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver resover = new StringValueResolver() {
                @Override
                public String resolveStringValue(String str) {
                    if (isObscene(str)) return "***";
                    return str;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(resover);
            visitor.visitBeanDefinition(bd);
        }
    }

    private boolean isObscene(String str) {
        String upperStr = str.toUpperCase();
        return this.obscenities.contains(upperStr);
    }

    public Set<String> getObscenities() {
        return obscenities;
    }

    public void setObscenities(Set<String> obscenities) {
        this.obscenities.clear();
        for (String obscenity : obscenities) {
            this.obscenities.add(obscenity.toUpperCase());
        }
    }
}
