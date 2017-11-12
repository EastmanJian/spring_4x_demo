package jdbctemplate.sql;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This example requires the following DB environment to run.
 *   DBMS: MySQL,
 *   Host: localhost (127.0.0.1)
 *   Port: 3306 (default)
 *   DB Account: root
 *   Password: password
 *   Schema (DB): test
 *   Tables: student (refer to test.sql for the DDL, they should be empty before run the demo)
 *   Java lib (additional to Spring core libs):
 *     mysql-connector-java.jar
 *     spring-jdbc.jar
 *
 * Change the config if you ride on another DBMS.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansJdbcTemplateSql.xml");

        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");

        System.out.println("------Records Creation--------" );
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----" );
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.println(", Age : " + student.getAge());
    }
}