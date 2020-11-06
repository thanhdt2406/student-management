package dao.teacher_service;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import dao.ConnectDB;
import model.staff.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherService implements ITeacherService {
    List<Teacher> teachers = new ArrayList<>();
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
                String role = rs.getString("role");
                String phone_number = rs.getString("phone number");
                String status = rs.getString(" status");
                float salary = Float.parseFloat(rs.getString("salary"));
                teachers.add(new Teacher(id, role, name, phone_number, status, salary));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return teachers;
    }

    @Override
    public boolean addNewTeacher(Teacher teacher) {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "insert into teacher(id,name,phone_number,status,salary)" + "values(?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getPhoneNumber());
            ps.setString(4, teacher.getStatus());
            ps.setFloat(5, teacher.getSalary());

            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void editTeacher(int teacherID) {

    }

    @Override
    public void deleteTeacher(int teacherID) {

    }
}
