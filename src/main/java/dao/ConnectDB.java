package dao;

import java.sql.*;

public class ConnectDB {
    final static String DB_URL = "jdbc:mysql://localhost:3306/case_study_m3?serverTimezone=UTC";
    final static String jdbc_USERNAME = "root";
    final static String jdbc_PASSWORD = "";

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

    public static Connection getConnection() {
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
}
