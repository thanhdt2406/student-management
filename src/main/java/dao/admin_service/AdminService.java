package dao.admin_service;

import dao.ConnectDB;
import model.Classroom;
import model.diary.Diary;
import model.Student;
import model.User;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements IAdminService {
    private final String SELECT_ALL_USER = "select * from user;";

    public AdminService() {

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
        List<User> users = new ArrayList<>();
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                String signUpDate = resultSet.getString("signUp_date");
                users.add(new User(id,username,password,role,signUpDate));
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
