package dao.teacher_service;

import model.staff.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> showAllteacher();
    boolean addNewTeacher(Teacher teacher);
    void editTeacher(int teacherID);
    void deleteTeacher(int teacherID);

}
