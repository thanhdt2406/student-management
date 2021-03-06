package dao.student_service;

import model.Student;

import java.util.List;

public interface IStudentService {
    boolean addNewStudent(Student student);
    List<Student> getAllStudent();
    boolean deleteStudent(int studentID);
    void editStudent(Student student);
    Student getStudentInfor(int id);

    String getClassOfStudent(int classID);
    int AvgPracticeMark();
    int AvgTheoreticalMark();
    List<Student> getStudentInClass(int classID);
    boolean changeStatus(int ID);

}
