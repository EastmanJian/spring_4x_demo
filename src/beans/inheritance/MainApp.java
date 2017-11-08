package beans.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansDefInherit.xml");

        HelloWorldBean objA = (HelloWorldBean) context.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();

        HelloEndoraBean objB = (HelloEndoraBean) context.getBean("helloEndora");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
    }
}