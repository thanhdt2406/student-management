package controller;

import dao.mark_service.IMarkService;
import dao.mark_service.MarkService;
import dao.subject_service.ISubjectService;
import dao.subject_service.SubjectService;
import model.Mark;
import model.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SubjectServlet", urlPatterns = "/subject")
public class SubjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "editMark":
                int markID = Integer.parseInt(request.getParameter("markID"));
                Double practiceMark = Double.parseDouble(request.getParameter("newPracticeMark"));
                Double theoreticalMark = Double.parseDouble(request.getParameter("newTheoreticalMark"));
                IMarkService markService = new MarkService();
                markService.editMark(markID,practiceMark,theoreticalMark);
                response.sendRedirect("/accountInformation");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int studentID;
        RequestDispatcher requestDispatcher;
        ISubjectService subjectService = new SubjectService();
        List<Subject> subjects;
        IMarkService markService = new MarkService();
        switch (action) {
            case "showMark":
                studentID = Integer.parseInt(request.getParameter("ID"));
                int subID = Integer.parseInt(request.getParameter("subID"));
                Mark mark = markService.getMark(studentID, subID);
                request.setAttribute("mark", mark);
                request.setAttribute("studentID", studentID);
                request.setAttribute("subID", subID);
                requestDispatcher = request.getRequestDispatcher("view/academicStaff/DisplayMark.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "showSubject":
                studentID = Integer.parseInt(request.getParameter("studentID"));
                request.setAttribute("studentID", studentID);
                subjectService = new SubjectService();
                subjects = subjectService.listSubject();
                request.setAttribute("subjects", subjects);
                requestDispatcher = request.getRequestDispatcher("view/academicStaff/DisplaySubject.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "showStudentSubject":
                studentID = Integer.parseInt(request.getParameter("studentID"));
                request.setAttribute("studentID", studentID);
                subjects = subjectService.getStudentSubject(studentID);
                request.setAttribute("subjects", subjects);
                requestDispatcher = request.getRequestDispatcher("view/academicStaff/DisplaySubject.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "editMark":
                int markID = Integer.parseInt(request.getParameter("markID"));
                Mark mark1 = markService.getMarkByMarkID(markID);
                request.setAttribute("mark",mark1);
                requestDispatcher = request.getRequestDispatcher("/view/academicStaff/EditMark.jsp");
                requestDispatcher.forward(request,response);
                break;
        }

    }
}
