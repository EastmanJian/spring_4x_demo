package beans.postprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansPostProcessor.xml");

        ExampleBean objA = (ExampleBean) context.getBean("beanExample1");
        objA.getMessage();
        ExampleBean objB = (ExampleBean) context.getBean("beanExample2");
        objB.getMessage();
        context.registerShutdownHook();
    }
}