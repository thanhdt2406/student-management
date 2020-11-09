package dao.subject_service;

import dao.ConnectDB;
import model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectService implements ISubjectService {
    private ConnectDB connectDB = ConnectDB.getInstance();
    private Connection connection = connectDB.getConnection();
    @Override
    public boolean addNewSubject(Subject subject) {
        String sql = "call createNewSubject(?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setString(1,subject.getSubName());
            stm.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSubject(int id) {
        String sql = "delete from subject where subId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,id);
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Subject> listSubject() {
        List<Subject> list = new ArrayList<>();
        String sql = "select * from subject;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Subject(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean editSubject(int id, String name) {
        String sql = "call editSubject(?,?)";
        try {
            CallableStatement stm = connection.prepareCall(sql);
            stm.setInt(1,id);
            stm.setString(2,name);
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Subject> getAllSubject(){
        List<Subject> subjectList = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "select * from Subject;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int subID = rs.getInt(1);
                String subName = rs.getString(2);
                subjectList.add(new Subject(subID, subName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subjectList;
    }

    @Override
    public List<Subject> getStudentSubject(int studentID) {
        List<Subject> list = new ArrayList<>();
//        String sql = "select subject.* from subject join mark m on subject.subId = m.subID join student s on s.id = m.studentID and studentID = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select subject.* from subject join mark m on subject.subId = m.subID join student s on s.id = m.studentID and s.id = ?;");
            preparedStatement.setInt(1,studentID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Subject(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


}
