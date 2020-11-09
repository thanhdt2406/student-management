package model.staff;

public class Teacher extends Staff {
    boolean status;

    public Teacher(String name, String phoneNumber, String address, boolean status, int salary, boolean status1) {
        super(name, phoneNumber, address, status, salary);
        this.status = status1;
    }

    public Teacher(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary, boolean status1) {
        super(userId, username, password, role, signUpDate, name, phoneNumber, address, status, salary);
        this.status = status1;
    }

    public Teacher(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary, boolean status1) {
        super(username, password, role, signUpDate, name, phoneNumber, address, status, salary);
        this.status = status1;
    }

    public Teacher(String username, String password, String role, String name, String phoneNumber, String address, boolean status, int salary, boolean status1) {
        super(username, password, role, name, phoneNumber, address, status, salary);
        this.status = status1;
    }

    public Teacher(int userId, String username, String password, String role, String signUpDate, String name, boolean status) {
        super(userId, username, password, role, signUpDate, name);
        this.status = status;
    }

    public Teacher(int username, String password, String role, String signUpDate, boolean name, float status) {
        super(username, password, role, signUpDate, name);
        this.status = status;
    }

    public Teacher(String username, String password, String role, String name, boolean status) {
        super(username, password, role, name);
        this.status = status;
    }

    public Teacher(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary, boolean status) {
        super(userId, username, password, role, signUpDate, name, phoneNumber, address, salary);
        this.status = status;
    }

    public Teacher(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary, boolean status) {
        super(username, password, role, signUpDate, name, phoneNumber, address, salary);
        this.status = status;
    }

    public Teacher(String username, String password, String role, String name, String phoneNumber, String address, int salary, boolean status) {
        super(username, password, role, name, phoneNumber, address, salary);
        this.status = status;
    }

    public Teacher(int id, String name, String phone, String address, boolean status, int salary, boolean status1) {
        super(id, name, phone, address, status, salary);
        this.status = status1;
    }

    public Teacher(String username, String password, String name, String phoneNumber, String address, boolean status, int salary, boolean status1) {
        super(username, password, name, phoneNumber, address, status, salary);
        this.status = status1;
    }

    public Teacher(String username, String password, String name, String phonenumber, String address, int salary, boolean status) {
        super(username, password, name, phonenumber, address, salary);
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
