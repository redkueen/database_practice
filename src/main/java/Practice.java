import java.sql.*;

public class Practice {
    public static void main(String[]args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://10.1.2.107:3306/shopping","root","root");
            //     url:       http://127.0.0.1

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select user_id,name,password from users ");
            while(true) {
                boolean next = resultSet.next();
                if (next == true) {
                    long id = resultSet.getLong("user_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    System.out.println(id + name + password);
                }
                break;

            }
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
