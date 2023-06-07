import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","Password");
        Statement statement=con.createStatement();

        //TASK 1. Update pass_grade to 475 of Mathematics department (use PreparedStatement)

        statement.close();
        con.close();
    }
}
