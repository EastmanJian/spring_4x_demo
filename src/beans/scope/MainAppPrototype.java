package beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppPrototype {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansScope.xml");
        ScopeDemoBean objA = (ScopeDemoBean) context.getBean("prototypeBean");

        objA.setMessage("I'm object A");
        objA.getMessage();

        ScopeDemoBean objB = (ScopeDemoBean) context.getBean("prototypeBean");
        objB.getMessage();
    }
}