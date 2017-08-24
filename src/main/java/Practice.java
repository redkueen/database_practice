import java.sql.*;

public class Practice {
    public static void main(String[]args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopping","root","root");
            //     url:       http://127.0.0.1

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select user_id,name,password from users where user_id = 1");
            resultSet.next();
           long id = resultSet.getLong("user_id");
           String name = resultSet.getString("name");
           String password = resultSet.getString("password");

           System.out.println(id + name + password );
           resultSet.close();
           statement.close();
           connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
