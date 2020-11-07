package dao.classdiary_service;

import model.diary.ClassDiary;

import java.util.List;

public interface IClassDiaryService {
    boolean createNewClassDiary(ClassDiary classDiary);

    boolean editClassDiary(int diaryID, String content);

    List<ClassDiary> getClassDiary(int classID);
}
