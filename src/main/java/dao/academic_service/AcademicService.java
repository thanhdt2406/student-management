package dao.academic_service;

import dao.ConnectDB;
import model.User;
import model.staff.AcademicStaff;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicService implements IAcademmicService {
    //private Map<Integer, AcademicStaff> academicStaffMap = new HashMap<>();
    private ConnectDB connectDB = ConnectDB.getInstance();
    private Connection connection = connectDB.getConnection();

    public AcademicService() {
    }

    @Override
    public boolean addNewAcademicStaff(AcademicStaff as) {
        String sql = "call createNewAcademicStaffFullInformation(?,?,?,?,?,?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);

            stm.setString(1, as.getUsername());
            stm.setString(2, as.getPassword());
            stm.setString(3, as.getName());
            stm.setString(4, as.getPhoneNumber());
            stm.setString(5, as.getAddress());
            stm.setInt(6, as.getSalary());

            int rs = stm.executeUpdate();
            if (rs != 0) {
                return true;
            }
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("trùng username");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AcademicStaff> listAcademicStaff() {
        List<AcademicStaff> list = new ArrayList<>();
        String sql = "SELECT * FROM academic_staff";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String address = rs.getString(4);
                int salary = rs.getInt(5);
                boolean status = rs.getBoolean(6);

                AcademicStaff obj = new AcademicStaff(id, name, phone, address, status, salary);
                System.out.println(obj.getName());
                list.add(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean deleteAS(int asID) {
        String sql = "call deleteAcademicStaff(?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1,asID);
            if (stm.execute()){
                return true;
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editAS(int asID) {
        String sql = "call editAcademicStaff(?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1,asID);
            if (stm.execute()){
                return true;
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
