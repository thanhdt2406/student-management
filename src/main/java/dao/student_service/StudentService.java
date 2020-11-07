package dao.student_service;

import dao.ConnectDB;
import model.Student;
import model.User;

import java.sql.*;
import java.util.*;

public class StudentService implements IStudentService {
    Map<Integer, Student> studentMap = new HashMap<>();
//    List<Student> studentList = new ArrayList<>();

    public StudentService() {
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public Student addNewStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM student;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
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
        String sql = "DELETE FROM Student WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, studentID);
            deleted = ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return deleted;
    }

    @Override
    public void editStudent(Student student) {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "UPDATE Student SET (name, phone_number, address, status, classID) VALUES (?, ?, ?, ?, ?) WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(6, student.getUserId());
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhoneNumber());
            ps.setString(3, student.getAddress());
            ps.setBoolean(4, student.isStatus());
            ps.setInt(5, student.getClassID());
            ps.executeUpdate();
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
