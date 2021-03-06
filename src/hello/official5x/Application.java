package hello.official5x;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


/**
 * The configuration metadata can be represented either by XML, Java annotations, or Java code.
 * In this HelloWorld application, the configuration metadata is represented by Java annotation and Java code.
 * Also the main application (Application.class) is combined with the Java Annotation configuration.
 * For XML configuration, see example in hello.tutorialspoint.MainAppPrototype.java
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}