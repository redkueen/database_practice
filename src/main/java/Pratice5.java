import java.sql.*;

public class Pratice5 {
    public static void main(String[]args){

        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.2.107:3306/bank","root","root");

           Statement statement = connection.createStatement();
           connection.setAutoCommit(false);
          ResultSet resultSet = statement.executeQuery("select balance from user where id =1");

          boolean next = resultSet.next();
          int balance = resultSet.getInt("balance");

         if(balance>10000) {
             int rowcount0 = statement.executeUpdate("update user set balance =balance -10000 where id =1");
             int rowcount1 = statement.executeUpdate("update user set balance =balance +10000 where id =2");
             connection.commit();

             System.out.println(rowcount0 + " " + rowcount1);
         }
         else {
             connection.rollback();
             System.out.println("回滚啦！");
         }

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
