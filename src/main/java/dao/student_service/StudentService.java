package dao.student_service;

import model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    Map<Integer, Student> studentMap = new HashMap<>();



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
    public List<Student> showAllStudent() {
        return null;
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
