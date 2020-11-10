package model.diary;

public class StudentDiary extends Diary{
    private int studentID;
    private String studentName;

    public StudentDiary(String content, int studentID) {
        super(content);
        this.studentID = studentID;
    }

    public StudentDiary(int id, String content, int studentID) {
        super(id, content);
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public StudentDiary(int id, String content, String date, int studentID, String studentName) {
        super(id, content, date);
        this.studentID = studentID;
        this.studentName = studentName;
    }
    public StudentDiary(int id, String content, String date, int studentID) {
        super(id, content, date);
        this.studentID = studentID;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
