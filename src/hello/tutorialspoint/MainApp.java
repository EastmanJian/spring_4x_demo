package hello.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext() - this API loads beans configuration file and eventually based on the
        // provided API, it takes care of creating and initializing all the objects, i.e. beans mentioned in
        // the configuration file.
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        //get the required bean using ApplicationContext.getBean() method of the created context. This method uses
        // bean ID (configured in the Beans.xml) to return a generic object, which finally can be casted to the actual
        // object. Once you have an object, you can use this object to call any class method.
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

        obj.getMessage();
    }
}