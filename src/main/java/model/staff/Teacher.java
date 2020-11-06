package model.staff;

import model.User;

public class Teacher extends User {
    public Teacher() {

    }

    public Teacher(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public Teacher(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public Teacher(String username, String password, String name, String role) {
        super(username, password, name, role);
    }
}
