package annotation.jsr250;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppEditor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansAnnotationJSR250Resource.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();
    }
}