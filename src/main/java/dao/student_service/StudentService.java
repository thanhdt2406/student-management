package dao.student_service;

import dao.ConnectDB;
import model.Student;

import java.sql.*;
import java.util.*;

public class StudentService implements IStudentService {
    List<Student> list = new ArrayList<>();

    private final String ADD_NEW_STUDENT = "call createNewStudentFullInformation(?, ?, ?, ?, ?, ?)";
    private final String EDIT_STUDENT = "call editStudent(?, ?, ?, ?, ?, ?);";
    private final String DELETE_STUDENT = "call deleteStudent(?);";

    public StudentService() {
    }


    @Override
    public boolean addNewStudent(Student student) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            CallableStatement cs = connection.prepareCall(ADD_NEW_STUDENT);
            cs.setString(1, student.getUsername());
            cs.setString(2, student.getPassword());
            cs.setString(3, student.getName());
            cs.setInt(4, student.getClassID());
            cs.setString(5, student.getPhoneNumber());
            cs.setString(6, student.getAddress());
            cs.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getAllStudent() {
        Connection connection = ConnectDB.getInstance().getConnection();
        String GET_ALL_STUDENT = "select * from student";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(GET_ALL_STUDENT);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String phone = rs.getString("phone_number");
                boolean status = rs.getBoolean("status");
                int classID = rs.getInt("classID");
                Student student = new Student(id, name, phone, status, classID);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    @Override
    public Student getStudentInfor(int id){
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "select * from student where id = " + id;
        Student student = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString(2);
                String phone = rs.getString(4);
                String role = rs.getString(3);
                boolean status = rs.getBoolean(5);
                int classID = rs.getInt(6);
                student = new Student(id, name, phone, status, classID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean deleteStudent(int studentID) {
        boolean deleted = false;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            CallableStatement cs = connection.prepareCall(DELETE_STUDENT);
            cs.setInt(1, studentID);
            deleted = cs.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleted;
    }

    @Override
    public void editStudent(Student student) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            CallableStatement cs = connection.prepareCall(EDIT_STUDENT);
            cs.setInt(1, student.getUserId());
            cs.setString(2, student.getName());
            cs.setString(3, student.getPhoneNumber());
            cs.setString(4, student.getAddress());
            cs.setBoolean(5, student.isStatus());
            cs.setInt(6, student.getClassID());
            cs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int AvgPracticeMark() {
        return 0;
    }

    @Override
    public int AvgTheoreticalMark() {
        return 0;
    }

    @Override
    public List<Student> getStudentInClass(int classID) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where classID = ?;");
            preparedStatement.setInt(1,classID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone_number");
                String address = rs.getString("address");
                boolean status = rs.getBoolean("status");
                Student student = new Student(id,name,phone,address,status,classID);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
