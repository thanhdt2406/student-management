package dao.admin_service;

import model.Classroom;
import model.Diary;
import model.Student;
import model.User;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import java.util.List;

public class AdminService implements IAdminService {
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
    public List<User> showUserList() {
        return null;
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
