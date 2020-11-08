package dao.teacher_service;

import model.Classroom;
import model.staff.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> showAllTeacher();
    boolean addNewTeacher(Teacher teacher);
    boolean editTeacher(Teacher teacher);
    boolean deleteTeacher(int teacherID);
    List<Classroom> getClassRoom();

}
