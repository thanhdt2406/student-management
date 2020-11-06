import dao.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();

        if (connection != null) {
            String sql = "SELECT * FROM user";

            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("role"));

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println("connection");
        System.out.println(connection);
    }
}
