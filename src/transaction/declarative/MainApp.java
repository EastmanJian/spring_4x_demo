package transaction.declarative;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * This example requires the following DB environment to run.
 *   DBMS: MySQL
 *   Host: localhost (127.0.0.1)
 *   Port: 3306 (default)
 *   DB Account: root
 *   Password: password
 *   Schema (DB): test
 *   Tables: student, marks (refer to test.sql for the DDL, they should be empty before run the demo)
 *   Java lib (additional to Spring core libs):
 *     mysql-connector-java.jar
 *     spring-jdbc.jar
 *     spring-tx.jar
 *
 * Change the config if you ride on another DBMS.
 *
 * The StudentJDBCTemplate.crete() method is managed by transaction using AOP declarative transaction management.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansTxDeclarative.xml");

        StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");

        System.out.println("------Records creation--------");
        try {
            studentJDBCTemplate.create("Zara", 11, 99, 2010);
            studentJDBCTemplate.create("Ayan", 25, 100, 2011);
            studentJDBCTemplate.create("Nuha", 20, 97, 2010);
        } catch (DataAccessException e) {
            System.out.println("MainApp - Error while inserting student records.");
        }

        System.out.println("------Listing all the records--------");
        List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
        for (StudentMarks record : studentMarks) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.print(", Marks : " + record.getMarks());
            System.out.print(", Year : " + record.getYear());
            System.out.println(", Age : " + record.getAge());
        }
    }
}