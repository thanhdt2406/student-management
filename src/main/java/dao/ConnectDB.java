package dao;

import java.sql.*;

public class ConnectDB {
    final String DB_URL = "jdbc:mysql://localhost:3306/testCase3?useSSL=false";
    final String jdbc_USERNAME = "root";
    final String jdbc_PASSWORD = "";

    private static ConnectDB instance;

    private ConnectDB() {
    }

    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
            return instance;
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, jdbc_USERNAME, jdbc_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (connection != null) {
            System.out.println("connect database succeed!");
        }
        return connection;
    }

    public static void main(String[] args) {
        ConnectDB main = new ConnectDB();
        Connection connection = main.getConnection();

        if (connection != null) {
            String sql = "SELECT * FROM user";

            try {
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
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
