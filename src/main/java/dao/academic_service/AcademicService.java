package dao.academic_service;

import dao.ConnectDB;
import model.User;
import model.staff.AcademicStaff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicService implements IAcademmicService {
    private Map<Integer, AcademicStaff> academicStaffMap = new HashMap<>();
    private ConnectDB connectDB = ConnectDB.getInstance();

    public AcademicService() {
    }

    @Override
    public boolean addNewAcademicStaff(AcademicStaff academicStaff) {
        return false;
    }

    @Override
    public List<AcademicStaff> listAcademicStaff() {
        Connection connection = connectDB.getConnection();
        String sql = "SELECT * FROM academic_staff";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
               int id = rs.getInt(1);
                AcademicStaff academicStaff = new AcademicStaff(id,"username","password","name",);
                academicStaffMap.put(academicStaff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteAS(int asID) {
        return false;
    }

    @Override
    public boolean editAS(int asID) {
        return false;
    }
}
