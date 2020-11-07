package model.diary;

public class ClassDiary extends Diary{
    private int classID;

    public ClassDiary(String content, int classID) {
        super(content);
        this.classID = classID;
    }

    public ClassDiary(int id, String content, int classID) {
        super(id, content);
        this.classID = classID;
    }

    public ClassDiary(int id, String content, String date, int classID) {
        super(id, content, date);
        this.classID = classID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
}
