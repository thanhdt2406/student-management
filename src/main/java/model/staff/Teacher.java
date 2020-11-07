package model.staff;

public class Teacher extends Staff {
    boolean status;
    public Teacher(int userId, String username, String password, String role, String signUpDate, String name) {
        super(userId, username, password, role, signUpDate, name);
    }

    public Teacher(String username, String password, String role, String signUpDate, String name) {
        super(username, password, role, signUpDate, name);
    }

    public Teacher(String username, String password, String role, String name) {
        super(username, password, role, name);
    }

    public Teacher(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(userId, username, password, role, signUpDate, name, phoneNumber, address, salary);
    }

    public Teacher(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(username, password, role, signUpDate, name, phoneNumber, address, salary);
    }

    public Teacher(String username, String password, String role, String name, String phoneNumber, String address, int salary) {
        super(username, password, role, name, phoneNumber, address, salary);
    }

    public Teacher(int userID, String username, String password, String role, String date, String name, String phoneNumber, String address, boolean status, int salary) {
        super(userID, username, password, role, date, name, phoneNumber, address, salary);
        this.status = status;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "status=" + status +
//                '}';
//    }
}
