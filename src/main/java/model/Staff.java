package model;

public class Staff extends User {
    private int salary;

    public Staff(String username, String password, String name, String role, String phoneNumber, int salary) {
        super(username, password, name, role, phoneNumber);
        this.salary = salary;
    }

    public Staff(int userId, String username, String password, String name, String role, String phoneNumber, int salary) {
        super(userId, username, password, name, role, phoneNumber);
        this.salary = salary;
    }

    public Staff(String username, String password, String name, String role, int salary) {
        super(username, password, name, role);
        this.salary = salary;
    }

    public Staff(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public Staff(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public Staff(String username, String password, String name, String role) {
        super(username, password, name, role);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
