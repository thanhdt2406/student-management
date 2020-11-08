package dao.admin_service;

import dao.ConnectDB;
import model.Classroom;
import model.diary.Diary;
import model.Student;
import model.User;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements IAdminService {
    private List<User> users;
    private final String SELECT_ALL_USER = "select * from user;";

    public AdminService() {
        this.users = new ArrayList<>();
    }

    public AdminService(List<User> users) {
        this.users = users;
    }

    public User login(String username, String password) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from user where username = "+username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean createNewClassroom(Classroom classroom) {
        return false;
    }

    @Override
    public boolean createNewStudent(Student student) {
        return false;
    }

    @Override
    public boolean createNewTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean createNewAS(AcademicStaff as) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            PreparedStatement ps = connection.prepareCall(SELECT_ALL_USER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String signUpDate = resultSet.getString("signUp_Date");
                users.add(new User(id, username, password, role, signUpDate));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Teacher> showTeacherList() {
        return null;
    }

    @Override
    public List<AcademicStaff> showASList() {
        return null;
    }

    @Override
    public List<Student> showStudentsList() {
        return null;
    }

    @Override
    public Diary showDiaryList() {
        return null;
    }

    @Override
    public Diary writeDiary() {
        return null;
    }
}
