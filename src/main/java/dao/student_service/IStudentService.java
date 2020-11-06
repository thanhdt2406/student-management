package dao.student_service;

import model.Student;

import java.util.List;

public interface IStudentService {
    Student addNewStudent(Student student);
    List<Student> showAllStudent();
    boolean deleteStudent(int studentID);
    void editStudent(int studentID);

    int AvgPracticeMark();
    int AvgTheoreticalMark();

}
