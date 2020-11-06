package dao.student_service;

import dao.ConnectDB;
import model.Student;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Connection connection = ConnectDB.getConnection();
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

    public static void main(String[] args) {
        IStudentService service = new StudentService();
        List<Student> list;
        list = service.getAllStudent();
        for (Student one: list) {
            System.out.println(one.getName());
        }
    }

    @Override
    public boolean deleteStudent(int studentID) {
        return false;
    }

    @Override
    public void editStudent(int studentID) {

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
