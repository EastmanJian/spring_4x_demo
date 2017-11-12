package transaction.programmatic;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private PlatformTransactionManager transactionManager;

    //dataSource will be injected by Spring at runtime
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    //transactionManager will be injected by Spring
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        //To start a new transaction, you need to have an instance of TransactionDefinition with the appropriate
        //transaction attributes. Use default transaction attributes in this example.
        TransactionDefinition def = new DefaultTransactionDefinition();

        //Start the transaction by calling getTransaction() method, which returns an instance of TransactionStatus.
        //The TransactionStatus objects helps in tracking the current status of the transaction.
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplateObject.update(SQL1, name, age);

            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = jdbcTemplateObject.queryForObject(SQL2, Integer.class);

            String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
            jdbcTemplateObject.update(SQL3, sid, marks, year);

            //Example of rollback here. So record for Nuha will neither be inserted in student table nor marks table.
            if ("Nuha".equals(name)) {
                System.out.println("Rollback - Created Name = " + name + ", Age = " + age);
                transactionManager.rollback(status);
                return;
            }

            //Use commit() method of PlatformTransactionManager to commit the transaction
            System.out.println("Created Name = " + name + ", Age = " + age);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return;
    }

    public List<StudentMarks> listStudents() {
        String SQL = "select * from Student, Marks where Student.id=Marks.sid";
        List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());

        return studentMarks;
    }
}