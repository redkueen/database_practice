import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class practice1 {
    public static void main (String[]args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shopping","root","root");
            Statement statement = connection.createStatement();
            int rowcount = statement.executeUpdate("insert users(`name`,password,jifen)value('xiaohong','xh234878',467820)");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
