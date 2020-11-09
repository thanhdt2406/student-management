package dao.mark_service;

import model.Mark;

public interface IMarkService {
    boolean inputMark(int studentID, int subID, double practiceMark,double theoreticalMark);

    boolean editMark(int MarkID, double practiceMark,double theoreticalMark);

    Mark getMark(int studentID,int subID);

    Mark getMarkByMarkID(int markID);
}
