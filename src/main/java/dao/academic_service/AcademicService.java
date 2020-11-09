package dao.academic_service;

import dao.ConnectDB;
import model.staff.AcademicStaff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcademicService implements IAcademicService {
    //private Map<Integer, AcademicStaff> academicStaffMap = new HashMap<>();
    public AcademicService() {
    }

    @Override
    public boolean addNewAcademicStaff(AcademicStaff as) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "call createNewAcademicStaffFullInformation(?,?,?,?,?,?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);

            stm.setString(1, as.getUsername());
            stm.setString(2, as.getPassword());
            stm.setString(3, as.getName());
            stm.setString(4, as.getPhoneNumber());
            stm.setString(5, as.getAddress());
            stm.setFloat(6, as.getSalary());

            int rs = stm.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("trùng username");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AcademicStaff> listAcademicStaff() {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
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
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "call deleteAcademicStaff(?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1, asID);
            if (stm.execute()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editAS(int asID, String name, String phone, String address, boolean status) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "call editAcademicStaff(?,?,?,?,?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1, asID);
            stm.setString(2, name);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.setBoolean(5, status);
            if (stm.executeUpdate() != 0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
