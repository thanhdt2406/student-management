package controller;

import dao.ConnectDB;
import dao.student_service.IStudentService;
import dao.student_service.StudentService;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "StudentServlet", urlPatterns = "/student_handle")
public class StudentServlet extends HttpServlet {
    IStudentService service = new StudentService();

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

    private void displayAccInfor(HttpServletRequest request, HttpServletResponse response) {
        Student student = (Student) request.getAttribute("student");
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

    private void displayMark(HttpServletRequest request, HttpServletResponse response) {
        request.removeAttribute("fileNameRes");
        request.setAttribute("fileNameRes", "ListStudent");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/StudentIndex.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDefault(HttpServletRequest request, HttpServletResponse response) {
        Student student = (Student) request.getAttribute("student");
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
