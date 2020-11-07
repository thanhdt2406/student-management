package dao.user_service;

import dao.ConnectDB;
import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private final String SELECT_ALL_USER = "select * from user;";
    private final String CHANGE_PASSWORD = "call changePassword(?,?);";

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String signUpDate = resultSet.getString("signUp_date");
                users.add(new User(id, username, password, role, signUpDate));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean changePassword(int id, String password) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CHANGE_PASSWORD);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, password);
            int rs = callableStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
