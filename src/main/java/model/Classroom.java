package model;

public class Classroom {
    private int classID;
    private String name;
    private String startDate;

    public Classroom(){}

    public Classroom(int classID, String name, String startDate) {
        this.classID = classID;
        this.name = name;
        this.startDate = startDate;
    }

    public Classroom(String name, String startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Classroom(String name) {
        this.name = name;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
