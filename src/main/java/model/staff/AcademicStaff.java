package model.staff;

public class AcademicStaff extends Staff {

    public AcademicStaff(String username, String password, String name, String role, String phoneNumber, int salary) {
        super(username, password, name, role, phoneNumber, salary);
    }

    public AcademicStaff(int userId, String username, String password, String name, String role, String phoneNumber, int salary) {
        super(userId, username, password, name, role, phoneNumber, salary);
    }

    public AcademicStaff(String username, String password, String name, String role, int salary) {
        super(username, password, name, role, salary);
    }

    public AcademicStaff(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public AcademicStaff(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public AcademicStaff(String username, String password, String name, String role) {
        super(username, password, name, role);
    }
}
