package dao.user_service;

import dao.ConnectDB;
import model.Student;
import model.User;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import java.sql.*;
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

    @Override
    public User getUserInfor(int userID) {
        String GET_USER_INFO = "select * from user where id = ?;";
        User user = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement psAll = connection.prepareStatement(GET_USER_INFO);
            psAll.setInt(1, userID);
            ResultSet rsAll = psAll.executeQuery();
            while (rsAll.next()){
                String username = rsAll.getString("username");
                String password = rsAll.getString("password");
                String date = String.valueOf(rsAll.getDate("signUp_date"));
                String role = rsAll.getString("role");

                Statement psGet = connection.createStatement();
                ResultSet rsGet;
                String name, phoneNumber, address, sql;
                int classID, salary;
                boolean status;

                switch (role){
                    case "student":
                        sql = "select * from student where id = " + userID;
                        rsGet = psGet.executeQuery(sql);
                        rsGet.next();
                        name = rsGet.getString("name");
                        phoneNumber = rsGet.getString("phone_number");
                        address = rsGet.getString("address");
                        classID = rsGet.getInt("classID");
                        status = rsGet.getBoolean("status");
                        user = new Student(userID, username, password, role, date, name, phoneNumber, address, status, classID);
                        return user;
                    case "teacher":
                        sql = "select * from teacher where id = " + userID;
                        rsGet = psGet.executeQuery(sql);
                        rsGet.next();
                        name = rsGet.getString("name");
                        phoneNumber = rsGet.getString("phone_number");
                        address = rsGet.getString("address");
                        salary = rsGet.getInt("salary");
                        status = rsGet.getBoolean("status");
                        user = new Teacher(userID, username, password, role, date, name, phoneNumber, address, status, salary);
                        return user;
                    case "academic_staff":
                        sql = "select * from academic_staff where id = " + userID;
                        rsGet = psGet.executeQuery(sql);
                        rsGet.next();
                        name = rsGet.getString("name");
                        phoneNumber = rsGet.getString("phone_number");
                        address = rsGet.getString("address");
                        salary = rsGet.getInt("salary");
                        status = rsGet.getBoolean("status");
                        user = new AcademicStaff(userID, username, password, role, date, name, phoneNumber, address, status, salary);
                        return user;
                    default:
                        user = new User(userID, username, password, role, date);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
