package dao.classdiary_service;

import dao.ConnectDB;
import model.diary.ClassDiary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDiaryService implements IClassDiaryService {
    private final String CREATE_CLASS_DIARY = "call createNewClassDiary(?, ?);";
    private final String EDIT_CLASS_DIARY = "update class_diary set content = ? where diaryID = ?;";
    private final String GET_CLASS_DIARY = "select * from class_diary where classID = ?;";

    @Override
    public boolean createNewClassDiary(ClassDiary classDiary) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CREATE_CLASS_DIARY);
            callableStatement.setString(1, classDiary.getContent());
            callableStatement.setInt(2, classDiary.getClassID());
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
    public boolean editClassDiary(int diaryID, String content) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CLASS_DIARY);
            preparedStatement.setString(1, content);
            preparedStatement.setInt(2, diaryID);
            int rs = preparedStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ClassDiary> getClassDiary(int classID) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        List<ClassDiary> classDiaryList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CLASS_DIARY);
            preparedStatement.setInt(1,classID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int diaryID = resultSet.getInt("diaryID");
                String content = resultSet.getString("content");
                String date = resultSet.getString("date");
                classDiaryList.add(new ClassDiary(diaryID,content,date,classID));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return classDiaryList;
    }

    @Override
    public boolean deleteClassDiary(int diaryID) {
        String sql = "DELETE FROM class_diary WHERE diaryID = ?";
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,diaryID);
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ClassDiary> getAllClassDiary() {
        Connection connection = ConnectDB.getInstance().getConnection();
        List<ClassDiary> classDiaryList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from class_diary;");
            while (rs.next()){
                int diaryID = rs.getInt("diaryID");
                String content = rs.getString("content");
                String date = rs.getString("date");
                int classID = rs.getInt("classID");
                ClassDiary classDiary = new ClassDiary(diaryID,content,date,classID);
                classDiaryList.add(classDiary);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return classDiaryList;
    }
}
