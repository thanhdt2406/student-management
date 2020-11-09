package dao.mark_service;

import dao.ConnectDB;
import model.Mark;

import java.sql.*;

public class MarkService implements IMarkService{
    private final String INPUT_MARK = "call createNewMark(?,?,?,?);";
    private final String EDIT_MARK = "call editMark(?,?,?,?);";
    private final String GET_MARK = "call getMark(?,?);";

    @Override
    public boolean inputMark(int studentID, int subID, double practiceMark, double theoreticalMark) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try{
            CallableStatement callableStatement = connection.prepareCall(INPUT_MARK);
            callableStatement.setInt(1,subID);
            callableStatement.setInt(2,studentID);
            callableStatement.setDouble(3,practiceMark);
            callableStatement.setDouble(4,theoreticalMark);
            int rs = callableStatement.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editMark(int markID, double practiceMark, double theoreticalMark) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try{
            CallableStatement callableStatement = connection.prepareCall("update mark set practiceMark = ?, theoreticalMark=? where markID = ?;");
            callableStatement.setInt(3,markID);
            callableStatement.setDouble(1,practiceMark);
            callableStatement.setDouble(2,theoreticalMark);
            int rs = callableStatement.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public Mark getMark(int studentID, int subID) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from mark where subID = ? and studentID = ?;");
            preparedStatement.setInt(1,subID);
            preparedStatement.setInt(2,studentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int markID = resultSet.getInt("markID");
                double practiceMark = resultSet.getDouble("practiceMark");
                double theoreticalMark = resultSet.getDouble("theoreticalMark");
                return new Mark(markID,practiceMark,theoreticalMark);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Mark getMarkByMarkID(int markID) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from mark where markID = ?;");
            preparedStatement.setInt(1,markID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                double practiceMark = resultSet.getDouble("practiceMark");
                double theoreticalMark = resultSet.getDouble("theoreticalMark");
                return new Mark(markID,practiceMark,theoreticalMark);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
