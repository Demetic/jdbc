import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        //Create connection
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","Password");

        //Create statement
        Statement statement=con.createStatement();
        System.out.println("********************** Task 1 **************************************");
        //TASK-1. GET/SELECT  "country_name" from countries table with ID between 5 and 10
        String query1="SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
        boolean sql1=statement.execute(query1);
        System.out.println("sql1 = " + sql1);

        //Select *from where id=60654;
        //TASK EXTRA:create workers table
        System.out.println("----------------extra task-----------------");
        String queryExtra="CREATE TABLE workers(worker_id CHAR, worker_name VARCHAR(80), worker_address VARCHAR(80))";

        boolean querySQLExtra= statement.execute(queryExtra);

        System.out.println("querySQLExtra = " + querySQLExtra);

        ResultSet resultSet=statement.executeQuery(query1);
        //resultSet.getString(1);
        //We can use column index number
        //System.out.println(resultSet.next());
//        resultSet.next();
//        System.out.println(resultSet.getString("country_name"));

        while(resultSet.next()){
            System.out.println(resultSet.getString("country_name"));// get column by columnLabel
            //System.out.println(resultSet.getString(1));  //get column by index number.

        }
        //ResultSet has method such first(), last(), or next()
        //There is no method to iterate backward
        System.out.println("*********************** Task 2 *************************88");

        //TASK - 2: Get "phone_code" and "country_name" from countries table,
        // whose phone code is greater than 200
        String query2="SELECT phone_code,country_name FROM countries WHERE phone_code>500";
        ResultSet resultSet2=statement.executeQuery(query2);

        while(resultSet2.next()){
            System.out.println(resultSet2.getInt("phone_code")+"--"+
                    resultSet2.getString("country_name"));
        }
        System.out.println("************************ Task 3 *****************");
        //TASK-3. Get all information about the developers whose salary is lowest
        String query3 = "SELECT * FROM developers WHERE salary = (SELECT min(salary) FROM developers)";
        ResultSet resultSet3 = statement.executeQuery(query3);

        while (resultSet3.next()){
            System.out.println(resultSet3.getInt("id")+" -- "+resultSet3.getString("name")+
                    " -- "+ resultSet3.getString("prog_lang") +" -- "+ resultSet3.getDouble("salary"));
        }
        System.out.println("******************************* Task 4 **********************");

        //TASK - 4 : Display students' name and grade whose grades are higher than  average passing grade of departments.
        String query4 = "SELECT name, grade FROM students WHERE grade> (SELECT AVG(pass_grade) FROM departments)";
        ResultSet resultSet4=statement.executeQuery(query4);
        while(resultSet4.next()){

            System.out.println(resultSet4.getString("name")+" -- "+resultSet4.getInt("grade"));
        }

        statement.close();
        con.close();



        }






    }

