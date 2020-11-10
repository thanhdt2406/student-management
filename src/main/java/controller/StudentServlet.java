package controller;

import dao.ConnectDB;
import dao.mark_service.MarkService;
import dao.student_service.IStudentService;
import dao.student_service.StudentService;
import dao.subject_service.SubjectService;
import model.Mark;
import model.Student;
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


@WebServlet(name = "StudentServlet", urlPatterns = "/student_handle")
public class StudentServlet extends HttpServlet {
    IStudentService service = new StudentService();
    Student student = new Student();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if  (action == null) {
            action = "";
        }
        switch (action) {
            case "change_password":
                break;
            case "class_infor":
                break;
            case "acc_infor":
                displayAccInfor(request, response);
                break;
            case "mark":
                displayMark(request,response);
                break;
            default:
                displayDefault(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if  (action == null) {
            action = "";
        }
        switch (action) {
            case "change_password":
                break;
            case "class_infor":
                displayStudentInClass(request, response);
                break;
            case "acc_infor":
                displayAccInfor(request, response);
                break;
            case "mark":
                displayMark(request,response);
                break;
            default:
                displayDefault(request, response);
                break;
        }
    }

    private void displayStudentInClass(HttpServletRequest request, HttpServletResponse response) {
        StudentService service = new StudentService();
        List<Student> studentList = service.getStudentInClass(student.getClassID());
        String classRoom = service.getClassOfStudent(student.getClassID());
        request.setAttribute("studentList", studentList);
        request.setAttribute("classRoom", classRoom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/student_displayClass.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void displayAccInfor(HttpServletRequest request, HttpServletResponse response) {
        StudentService service = new StudentService();
        String classRoom = service.getClassOfStudent(student.getClassID());
        request.setAttribute("classRoom", classRoom);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/StudentIndex.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMark(HttpServletRequest request, HttpServletResponse response) {
        SubjectService subjectService = new SubjectService();
        MarkService markService = new MarkService();
        List<Mark> markList = markService.getMarkOfStudent(student.getUserId());
        List<Subject> subjectList = subjectService.getAllSubject();
        request.setAttribute("markList", markList);
        request.setAttribute("subjectList", subjectList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/student_marks.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDefault(HttpServletRequest request, HttpServletResponse response) {
        student = (Student) request.getAttribute("student");
        StudentService service = new StudentService();
        String classRoom = service.getClassOfStudent(student.getClassID());
        request.setAttribute("classRoom", classRoom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/StudentIndex.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
