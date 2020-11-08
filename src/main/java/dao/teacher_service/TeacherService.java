package dao.teacher_service;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import dao.ConnectDB;
import model.Classroom;
import model.staff.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherService implements ITeacherService {
    List<Teacher> teachers = new ArrayList<>();
    List<Classroom> classRooms = new ArrayList<>();
    Map<Integer, Teacher> teacherMap = new HashMap<>();

    public TeacherService() {
    }

    public void setTeacherMap(Map<Integer, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public Map<Integer, Teacher> getTeacherMap() {
        return teacherMap;
    }

    @Override
    public List<Teacher> showAllTeacher() {
        teachers.clear();
        String sql = "select * from teacher;";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                float salary = Float.parseFloat(rs.getString("salary"));
                boolean status = rs.getInt("status") == 1;
                teachers.add(new Teacher(id, name, phoneNumber, address, salary));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return teachers;
    }

    @Override
    public boolean addNewTeacher(Teacher teacher) {
        boolean isAdded = false;
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "insert into teacher(id,name,phone_number,status,salary)" + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getUserName());
            ps.setString(3, teacher.getPhoneNumber());
            ps.setFloat(5, teacher.getSalary());
            isAdded = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public boolean editTeacher(Teacher teacher) {
        boolean isUpdated = false;
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "update [teacher] set userName = ?,PhoneNumber = ?, salary = ?  " + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4, teacher.getId());
            ps.setString(1, teacher.getUserName());
            ps.setString(2, teacher.getPhoneNumber());
            ps.setFloat(3, teacher.getSalary());

            isUpdated = ps.executeUpdate() > 0;//sex update du lieu trong data base tra ve so luong abn ghi duoc cap nhat
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean deleteTeacher(int teacherID) {
        boolean isDeleted = false;

        Connection connection = ConnectDB.getInstance().getConnection();
        String DELETE_QUERY = "DELETE FROM teacher WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
            ps.setInt(1, teacherID);
            isDeleted = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public List<Classroom> getClassRoom() {
        String sql = "select * from classroom;";
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String role = rs.getString("role");
                String phone_number = rs.getString("phone number");
                String status = rs.getString(" status");
                float salary = Float.parseFloat(rs.getString("salary"));
                classRooms.add(new Classroom());
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return classRooms;
    }
}
