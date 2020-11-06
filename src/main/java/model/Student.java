package model;

public class Student extends User {
    private int classID;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public Student() {
    }

    public Student(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public Student(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public Student(String username, String password, String name, String role) {
        super(username, password, name, role);
    }

    public Student(int id, String name, String phone, boolean status, int classID) {
        super(id, name, phone, status);
        this.classID = classID;
    }
}
