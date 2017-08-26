import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Pratice4 {
    public static void main(String[]args){

        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.2.107:3306/bank","root","root");

           Statement statement = connection.createStatement();
           connection.setAutoCommit(false);
         int rowcount0 = statement.executeUpdate("update user set balance =balance -10000 where id =1");
        int rowcount1 = statement.executeUpdate("update user set balance =balance +10000 where id =2");
        connection.commit();

        System.out.println(rowcount0 + " " + rowcount1);


            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
