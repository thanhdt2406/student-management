package dao;

import model.Classroom;
import model.diary.Diary;
import model.Student;
import model.User;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String SELECT_ALL_USER = "select * from user;";
    private final String GET_USER_INFO = "select * from user where id = ?;";
    private final String GET_COMMON_INFO = "select * from ? where id = ?;";

    public UserDAO() {
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
    public User getUserInfor(int userID) {
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
                        break;
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
                        break;
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
                        break;
                    default:
                        user = new User(userID, username, password, role, date);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

//    public static void main(String[] args) {
//        IUserDAO userDAO = new UserDAO();
//        User user = new User();
//        user = userDAO.getUserInfor(8);
//        System.out.println(user.toString());
//    }

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
