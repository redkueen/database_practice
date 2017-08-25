import java.sql.*;

public class Practice2 {
    public static void main(String[]args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopping","root","root");
            //     url:       http://127.0.0.1

            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate("delete FROM users where user_id = 3");
            System.out.println(rowCount);
           statement.close();
           connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
