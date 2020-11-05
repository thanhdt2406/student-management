package model;

public class student extends user{
    private double practiceMark;
    private double theoreticalMark;

    public student(String username, String password, String name, String role, String phoneNumber) {
        super(username, password, name, role, phoneNumber);
    }

    public student(int userId, String username, String password, String name, String role, String phoneNumber) {
        super(userId, username, password, name, role, phoneNumber);
    }

    public student(String username, String password, String name, String role) {
        super(username, password, name, role);
    }

    public double getPracticeMark() {
        return practiceMark;
    }

    public void setPracticeMark(double practiceMark) {
        this.practiceMark = practiceMark;
    }

    public double getTheoreticalMark() {
        return theoreticalMark;
    }

    public void setTheoreticalMark(double theoreticalMark) {
        this.theoreticalMark = theoreticalMark;
    }
}
