package dao.subject_service;

import model.Subject;

import java.util.List;

public interface ISubjectService {
    boolean addNewSubject(Subject subject);
    boolean deleteSubject(int id);
    List<Subject> listSubject();
    boolean editSubject(int id, String name);

    List<Subject> getStudentSubject(int studentID);

    List<Subject> getAllSubject();
}
