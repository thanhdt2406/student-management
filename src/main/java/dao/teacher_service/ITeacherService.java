package dao.teacher_service;

import model.Classroom;
import model.User;
import model.staff.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> showAllTeacher();
    boolean addNewTeacher(User user, Teacher teacher);
    boolean editTeacher(User user,Teacher teacher);
    boolean deleteTeacher(int teacherID);
    List<Classroom> getClassRoom();

}
