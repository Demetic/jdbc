import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "Password");
        Statement statement = con.createStatement();

        System.out.println("************** Task-1 **************");
        //TASK-1. Update pass_grade to 475 of Mathematics department (use PreparedStatement)
        //normal string query
        //String query1 = "UPDATE departments SET pass_grade = 475 WHERE department ILIKE 'mathematics'";

        //parameterized query
        String query1 = "UPDATE departments SET pass_grade = ? WHERE department ILIKE ?";
        //create prepared statement
        PreparedStatement prs = con.prepareStatement(query1);
        //set values for the parameters
        prs.setInt(1, 475);
        prs.setString(2, "mathematics");

        //execute the prepared statement
        int numOfUpdatedRows =  prs.executeUpdate();
        System.out.println("Updated data num: "+numOfUpdatedRows);

        System.out.println("************** Task-2 **************");
       prs.setInt(1,455);
       prs.setString(2,"Literature");
       int numOfUpdatedRows2=prs.executeUpdate();
        System.out.println("numOfUpdatedRows2 = " + numOfUpdatedRows2);

        //TASK-2. Insert software engineering department using prepared statement into departments table.
        // (id = 5006, pass_grade=475, campus='South')

        System.out.println("************** Task-3 **************");







        prs.close();
        statement.close();
        con.close();
    }
}
