package model.staff;

public class AcademicStaff extends Staff {

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
}
