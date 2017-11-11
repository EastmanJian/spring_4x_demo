package jdbctemplate.storedprocedure;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord")
                .withoutProcedureColumnMetaDataAccess() //Add this to avoid Exception in thread "main" org.springframework.dao.TransientDataAccessResourceException: CallableStatementCallback; SQL [{call getrecord()}]; Parameter out_name is not registered as an output parameter; nested exception is java.sql.SQLException: Parameter out_name is not registered as an output parameter
                .useInParameterNames("in_id")
                .declareParameters(
                        new SqlParameter("in_id", Types.NUMERIC),
                        new SqlOutParameter("out_name", Types.VARCHAR),
                        new SqlOutParameter("out_age", Types.INTEGER)
                );
/* another form of in out parameter declaration*/
//        jdbcCall.declareParameters(new SqlOutParameter("RETURN_VALUE", Types.INTEGER));
//        jdbcCall.addDeclaredParameter(new SqlParameter("in_id", Types.INTEGER));
//        jdbcCall.addDeclaredParameter(new SqlOutParameter("out_name", Types.VARCHAR));
//        jdbcCall.addDeclaredParameter(new SqlOutParameter("out_age", Types.INTEGER));
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";

        jdbcTemplateObject.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    public Student getStudent(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        jdbcCall.getJdbcTemplate().setResultsMapCaseInsensitive(true);
        jdbcCall.getJdbcTemplate().setSkipUndeclaredResults(true);
        Map<String, Object> out = jdbcCall.execute(in);

        Student student = new Student();
        student.setId(id);
        student.setName((String) out.get("out_name"));
        student.setAge((Integer) out.get("out_age"));
        return student;
    }

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }
}