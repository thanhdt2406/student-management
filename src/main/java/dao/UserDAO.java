package dao;

import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users;
    private final String SELECT_ALL_USER = "select * from user;";

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public UserDAO(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String phone_number = resultSet.getString("phone_number");
                users.add(new User(id,username,password,name,role,phone_number));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
