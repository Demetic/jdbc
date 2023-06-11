import java.sql.*;

public class MedunnaRoomDataBaseTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step: Register Driver - (optional)
        Class.forName("org.postgresql.Driver");

        //2.step : Create Connection to get connected to DB

        Connection con = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2",
                "select_user", "Medunna_pass_@6");

        //3. step: Create Statement -- to execute SQL queries
        Statement statement= con.createStatement();

        //Select * from room where id =60654;

        String sqlQuery="SELECT * FROM room where id =60654;";

        ResultSet resultSet= statement.executeQuery(sqlQuery);

        System.out.println("resultSet = " + resultSet);


    }
}
