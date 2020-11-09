package controller;

import dao.student_service.IStudentService;
import dao.student_service.StudentService;
import model.Student;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    }


    private void displayAccInfor(HttpServletRequest request, HttpServletResponse response) {
        Student student = null;
        int id = Integer.parseInt(request.getParameter("userId"));
        student = service.getStudentInfor(id);
        request.setAttribute("student", student);
        request.removeAttribute("fileNameRes");
        request.setAttribute("fileNameRes", "InforStudent");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/StudentIndex.jsp");
        try {
            dispatcher.forward(request,response);
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
        int id = (int) request.getAttribute("idStudent");

        StudentService service = new StudentService();
        Student student = service.getStudentInfor(id);
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
}
