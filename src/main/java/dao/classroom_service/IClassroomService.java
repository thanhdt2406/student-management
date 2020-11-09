package dao.classroom_service;

import model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> getAllClassroom();

    boolean createNewClassroom(Classroom classroom);

    boolean editClassroom(int classId, String name, String date);

    boolean deleteClassroom(int classId);
}
