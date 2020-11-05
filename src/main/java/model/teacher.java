package model;

public class teacher extends user{
    private int salary;

    public teacher(String username, String password, String name, String role, String phoneNumber, int salary) {
        super(username, password, name, role, phoneNumber);
        this.salary = salary;
    }

    public teacher(int userId, String username, String password, String name, String role, String phoneNumber, int salary) {
        super(userId, username, password, name, role, phoneNumber);
        this.salary = salary;
    }

    public teacher(String username, String password, String name, String role, int salary) {
        super(username, password, name, role);
        this.salary = salary;
    }

    public teacher(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public teacher(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public teacher(String username, String password, String name, String role) {
        super(username, password, name, role);
    }
}
