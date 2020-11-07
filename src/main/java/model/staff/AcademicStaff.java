package model.staff;

public class AcademicStaff extends Staff {
    boolean status;

    public AcademicStaff(int userId, String username, String password, String role, String signUpDate, String name) {
        super(userId, username, password, role, signUpDate, name);
    }

    public AcademicStaff(String username, String password, String role, String signUpDate, String name) {
        super(username, password, role, signUpDate, name);
    }

    public AcademicStaff(String username, String password, String role, String name) {
        super(username, password, role, name);
    }

    public AcademicStaff(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(userId, username, password, role, signUpDate, name, phoneNumber, address, salary);
    }

    public AcademicStaff(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, int salary) {
        super(username, password, role, signUpDate, name, phoneNumber, address, salary);
    }

    public AcademicStaff(String username, String password, String role, String name, String phoneNumber, String address, int salary) {
        super(username, password, role, name, phoneNumber, address, salary);
    }

    public AcademicStaff(int id, String name, String phone, String address, boolean status, int salary) {
        super(id,name,phone,address,status,salary);
    }

    public AcademicStaff(String username, String password, String name, String phonenumber, String address, int salary) {
        super(username,password,name,phonenumber,address,salary);
    }

    public AcademicStaff(int userID, String username, String password, String role, String date, String name, String phoneNumber, String address, boolean status, int salary) {
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
//        return "AcademicStaff{" +
//                "status=" + status +
//                '}';
//    }
}

