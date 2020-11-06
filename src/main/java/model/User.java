package model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String role;
    private String phoneNumber;
    private boolean status = true;

    public User() {

    }

    public User(String username, String password, String name, String role, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public User(int userId, String username, String password, String name, String role, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String password, String name, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(int id, String name, String phone, boolean status) {
        this.userId = id;
        this.name = name;
        this.phoneNumber = phone;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
}
