package model.staff;

public class Teacher extends Staff {
    private int idTeacher;



    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Teacher(int idTeacher,String name,String address,String phoneNumber, int salary, boolean status){
        super(name,address,phoneNumber, status, salary);
        this.idTeacher=idTeacher;
    }

    public Teacher(String name, String phoneNumber, String address, boolean status, int salary) {
        super(name, phoneNumber, address, status, salary);
    }

    public Teacher(int userId, String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary) {
        super(userId, username, password, role, signUpDate, name, phoneNumber, address, status, salary);
    }

    public Teacher(String username, String password, String role, String signUpDate, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password, role, signUpDate, name, phoneNumber, address, status, salary);
    }

    public Teacher(String username, String password, String role, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password, role, name, phoneNumber, address, status, salary);
    }

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

    public Teacher(int id, String name, String phone, String address, boolean status, int salary) {
        super(id, name, phone, address, status, salary);
    }

    public Teacher(String username, String password, String name, String phoneNumber, String address, boolean status, int salary) {
        super(username, password, name, phoneNumber, address, status, salary);
    }

    public Teacher(String username, String password, String name, String phonenumber, String address, int salary) {
        super(username, password, name, phonenumber, address, salary);
    }


//    public Teacher(int id, String name, String address, String phoneNumber, float salary, boolean status) {
//        super(id,name,address,phoneNumber,salary,status);
//    }
}
