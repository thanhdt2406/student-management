package dao.student_service;

import dao.ConnectDB;
import model.Student;
import model.User;

import java.sql.*;
import java.util.*;

public class StudentService implements IStudentService {
    Map<Integer, Student> studentMap = new HashMap<>();

    private final String ADD_NEW_STUDENT = "call creatNewStudent(?, ?, ?, ?, ? , ?)";
    private final String GET_ALL_STUDENT = "call getAllStudent();";
    private final String EDIT_STUDENT = "call editStudent(?, ?, ?, ?, ?, ?);";
    private final String DELETE_STUDENT = "call deleteStudent(?);";

    public StudentService() {
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }


    @Override
    public void addNewStudent(Student student) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            CallableStatement cs = connection.prepareCall(ADD_NEW_STUDENT);
            cs.setString(1, student.getUsername());
            cs.setString(2, student.getPassword());
            cs.setString(3, student.getName());
            cs.setInt(4,student.getClassID());
            cs.setString(5, student.getPhoneNumber());
            cs.setString(6, student.getAddress());
            cs.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudent() {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            CallableStatement cs = connection.prepareCall(GET_ALL_STUDENT);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(4);
                String role = rs.getString(3);
                boolean status = rs.getBoolean(5);
                int classID = rs.getInt(6);
                Student student = new Student(id, name, phone, status, classID);
                studentMap.put(id, student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Collection<Student> values = studentMap.values();
        List<Student> students = new ArrayList<>(values);
        return students;
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

//    public static void main(String[] args) {
//        IStudentService service = new StudentService();
//        List<Student> list;
//        list = service.getAllStudent();
//        for (Student one: list) {
//            System.out.println(one.getName());
//        }
//    }

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
}
