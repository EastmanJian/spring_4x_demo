package beans.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLifeCycle {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansLifeCycle.xml");

        LifeCycleDemoBean obj = (LifeCycleDemoBean) context.getBean("lifeCycle");
        obj.getMessage();
        context.registerShutdownHook();
    }
}
