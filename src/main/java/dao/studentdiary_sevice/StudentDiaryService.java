package dao.studentdiary_sevice;

import dao.ConnectDB;
import model.diary.ClassDiary;
import model.diary.StudentDiary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDiaryService implements IStudentDiaryService{

    @Override
    public boolean createNewStudentDiary(StudentDiary studentDiary) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "call createNewStudentDiary(?, ?)";
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, studentDiary.getContent());
            callableStatement.setInt(2, studentDiary.getStudentID());
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
    public boolean editStudentDiary(int diaryID, String content) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "update student_diary set content = ? where diaryID = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
    public List<StudentDiary> getStudentDiary(int studentID) {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "select * from student_diary where studentID = ?;";
        List<StudentDiary> studentDiaryList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,studentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int diaryID = resultSet.getInt("diaryID");
                String content = resultSet.getString("content");
                String date = resultSet.getString("date");
                studentDiaryList.add(new StudentDiary(diaryID,content,date,studentID));
                System.out.println(content);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return studentDiaryList;
    }

    @Override
    public boolean deleteStudentDiary(int studentID) {
        String sql = "DELETE FROM student_diary WHERE diaryID = ?";
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,studentID);
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<StudentDiary> getAllStudentDiary() {
        Connection connection = ConnectDB.getInstance().getConnection();
        List<StudentDiary> studentDiaryList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student_diary join student s on s.id = student_diary.studentID;");
            while (rs.next()){
                int diaryID = rs.getInt("diaryID");
                String content = rs.getString("content");
                String date = rs.getString("date");
                String name = rs.getString("name");
                int studentID = rs.getInt("studentID");
                StudentDiary studentDiary = new StudentDiary(diaryID,content,date,studentID,name);
                studentDiaryList.add(studentDiary);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return studentDiaryList;
    }
}
