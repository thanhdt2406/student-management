package dao.academic_service;

import model.staff.AcademicStaff;

import java.util.List;

public interface IAcademmicService {
    boolean addNewAcademicStaff(AcademicStaff academicStaff);
    List<AcademicStaff> listAcademicStaff();
    boolean deleteAS(int asID);
    boolean editAS(int asID);
}
