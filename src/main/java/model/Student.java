package model;

public class Student extends User {
    private String name;
    private String phoneNumber;
    private String address;
    private boolean status;

    public Student(int userId, String username, String password, String role, String signUpDate, String name) {
        super(userId, username, password, role, signUpDate);
        this.name = name;
    }

    public Student(String username, String password, String role, String signUpDate, String name) {
        super(username, password, role, signUpDate);
        this.name = name;
    }

    public Student(String username, String password, String role, String name) {
        super(username, password, role);
        this.name = name;
    }

    public Student(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address) {
        super(userId, username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address) {
        super(username, password, role, signUpDate);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String username, String password, String role, String name, String phoneNumber, String address) {
        super(username, password, role);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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
}
