package beans.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppTemplate {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansDefInheritTemplate.xml");

        HelloEndoraBean obj = (HelloEndoraBean) context.getBean("helloEndora");
        obj.getMessage1();
        obj.getMessage2();
        obj.getMessage3();
    }
}