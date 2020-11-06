package model.staff;

import model.User;

public class Teacher extends User {
    private int id;
    private String name;
    private String phoneNumber;
    private String status;
    private float salary;


    public Teacher() {

    }

    public Teacher(int id, String name, String phoneNumber, String status, float salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.salary = salary;
    }

    public Teacher(String username, String password, String name, String role, String phoneNumber, int id, String name1, String phoneNumber1, String status, float salary) {
        super(username, password, name, role, phoneNumber);
        this.id = id;
        this.name = name1;
        this.phoneNumber = phoneNumber1;
        this.status = status;
        this.salary = salary;
    }

    public Teacher(int userId, String username, String password, String name, String role, String phoneNumber, int id, String name1, String phoneNumber1, String status, float salary) {
        super(userId, username, password, name, role, phoneNumber);
        this.id = id;
        this.name = name1;
        this.phoneNumber = phoneNumber1;
        this.status = status;
        this.salary = salary;
    }

    public Teacher(String username, String password, String name, String role, int id, String name1, String phoneNumber, String status, float salary) {
        super(username, password, name, role);
        this.id = id;
        this.name = name1;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.salary = salary;
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

    public Teacher(int id, String role, String name, String phone_number, String status, float salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phone_number;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
