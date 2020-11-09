package model;

public class Mark {
    private int markID;
    private int subID;
    private double practiceMark;
    private double theoreticalMark;

    public Mark() {

    }

    public Mark(int markID, double practiceMark, double theoreticalMark) {
        this.markID = markID;
        this.practiceMark = practiceMark;
        this.theoreticalMark = theoreticalMark;
    }

    public Mark(double practiceMark, double theoreticalMark) {
        this.practiceMark = practiceMark;
        this.theoreticalMark = theoreticalMark;
    }

    public Mark(int markID, int subID, double practiceMark, double theoreticalMark) {
        this.markID = markID;
        this.subID = subID;
        this.practiceMark = practiceMark;
        this.theoreticalMark = theoreticalMark;
    }

    public int getSubID() {
        return subID;
    }

    public void setSubID(int subID) {
        this.subID = subID;
    }

    public int getMarkID() {
        return markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
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
