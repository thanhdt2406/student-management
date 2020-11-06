package model;

public class Student extends User {
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
}
