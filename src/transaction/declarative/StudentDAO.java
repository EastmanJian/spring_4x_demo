package transaction.declarative;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    /**
     * initialize database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * create a record in the Student and Marks tables.
     */
    public void create(String name, Integer age, Integer marks, Integer year);

    /**
     * list downall the records from the Student and Marks tables.
     */
    public List<StudentMarks> listStudents();
}