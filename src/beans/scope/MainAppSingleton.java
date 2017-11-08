package beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppSingleton {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansScope.xml");
        ScopeDemoBean objA = (ScopeDemoBean) context.getBean("singletonBean");

        objA.setMessage("I'm object A");
        objA.getMessage();

        ScopeDemoBean objB = (ScopeDemoBean) context.getBean("singletonBean");
        objB.getMessage();
    }
}