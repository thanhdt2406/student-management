package dao.classroom_service;

import dao.ConnectDB;
import model.Classroom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService implements IClassroomService {
    private final String CREATE_NEW_CLASSROOM = "call createNewClass(?);";
    private final String EDIT_CLASSROOM = "call editClass(?,?,?);";
    private final String GET_ALL_CLASSROOM = "select * from classroom;";

    @Override
    public List<Classroom> getAllClassroom() {
        List<Classroom> classrooms = new ArrayList<>();
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_CLASSROOM);
            while (resultSet.next()){
                int classId = resultSet.getInt("classID");
                String name = resultSet.getString("name");
                String startDate = resultSet.getString("startDate");
                classrooms.add(new Classroom(classId,name,startDate));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public boolean createNewClassroom(Classroom classroom) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CREATE_NEW_CLASSROOM);
            String name = classroom.getName();
            callableStatement.setString(1, name);
            int rs = callableStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editClassroom(int classId,String name, String startDate) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(EDIT_CLASSROOM);
            callableStatement.setInt(1,classId);
            callableStatement.setString(2, name);
            callableStatement.setString(3, startDate);
            int rs = callableStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteClassroom(int classId) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String deleteClass = "delete from classroom where classID ="+classId;
        String sql = "call deleteStudent(?)";
        String getStudentID = "SELECT id From student Where classID =" + classId;
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(getStudentID);
            while (rs.next()){
                int id = rs.getInt(1);
                CallableStatement callableStatement = connection.prepareCall(sql);
                callableStatement.setInt(1,id);
                callableStatement.executeUpdate();
            }
            stm.execute(deleteClass);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }


}