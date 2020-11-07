package dao;

import model.diary.Diary;
import model.User;
import model.staff.AcademicStaff;
import model.Classroom;
import model.Student;
import model.staff.Teacher;

import java.util.List;

public interface IUserDAO {
    boolean createNewClassroom(Classroom classroom);
    boolean createNewStudent(Student student);
    boolean createNewTeacher(Teacher teacher);
    boolean createNewAS(AcademicStaff as );

    List<User> getAllUsers();
    User getUserInfor(int userID);
    List<Teacher> showTeacherList();
    List<AcademicStaff> showASList();
    List<Student> showStudentsList();
    Diary showDiaryList();
    Diary writeDiary();
}
