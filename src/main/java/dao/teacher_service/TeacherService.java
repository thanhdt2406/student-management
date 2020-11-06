package dao.teacher_service;

import model.staff.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherService implements ITeacherService{
    Map<Integer,Teacher> teacherMap = new HashMap<>();

    public TeacherService() {
    }

    public void setTeacherMap(Map<Integer, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public Map<Integer, Teacher> getTeacherMap() {
        return teacherMap;
    }

    @Override
    public List<Teacher> showAllteacher() {
        return null;
    }

    @Override
    public boolean addNewTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public void editTeacher(int teacherID) {

    }

    @Override
    public void deleteTeacher(int teacherID) {

    }
}
