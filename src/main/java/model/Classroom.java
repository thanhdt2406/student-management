package model;

import java.util.List;

public class Classroom {
    private int classID;
    private String name;
    private String startDate;
    private int coachID;

    public Classroom() {

    }

    public Classroom(int classID, String name, int coachID) {
        this.classID = classID;
        this.name = name;
        this.coachID = coachID;
    }

    public Classroom(String name, int coachID) {
        this.name = name;
        this.coachID = coachID;
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

    public int getCoachID() {
        return coachID;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }

}
