package model.staff;

import model.User;

public class Staff extends User {
    private String name;
    private String phoneNumber;
    private String address;
    private boolean status;
    private float salary;



    public Staff(String name, String phoneNumber, String address, boolean status, int salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary) {
        super(userId, username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(String username, String password, String role, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password, role);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(int userId, String username, String password, String role, String signUpDate, String name) {
        super(userId, username, password, role, signUpDate);
        this.name = name;
    }

    public Staff(String username, String password, String role, String signUpDate, String name) {
        super(username, password, role, signUpDate);
        this.name = name;
    }

    public Staff(String username, String password, String role, String name) {
        super(username, password, role);
        this.name = name;
    }

    public Staff(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(userId, username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public Staff(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public Staff(String username, String password, String role, String name, String phoneNumber, String address, int salary) {
        super(username, password, role);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public Staff(int id, String name, String phone, String address, boolean status, int salary) {
        super(id);
        this.name = name;
        this.phoneNumber = phone;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(String username, String password, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public Staff(String username, String password, String name, String phonenumber, String address, int salary) {
        super(username,password);
        this.name = name;
        this.phoneNumber = phonenumber;
        this.address = address;
        this.salary = salary;
    }

//    public Staff(int id, String name, String address, String phoneNumber, float salary, boolean status) {
//        super(id,name,address,phoneNumber,salary,status);
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
