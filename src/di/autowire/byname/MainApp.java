package di.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansAutowireByName.xml");

        EmployeeBean employee = (EmployeeBean)context.getBean("employee");
        System.out.println(employee.getFullName());
        System.out.println(employee.getDepartmentBean().getName());
    }
}