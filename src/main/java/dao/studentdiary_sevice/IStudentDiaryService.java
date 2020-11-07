package dao.studentdiary_sevice;
import model.diary.StudentDiary;

import java.util.List;

public interface IStudentDiaryService {
    boolean createNewStudentDiary(StudentDiary studentDiary);

    boolean editStudentDiary(int diaryID, String content);

    List<StudentDiary> getStudentDiary(int studentID);

    boolean deleteStudentDiary(int studentID);
}
