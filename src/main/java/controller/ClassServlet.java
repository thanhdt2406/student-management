package controller;

import dao.classroom_service.ClassroomService;
import dao.classroom_service.IClassroomService;
import dao.student_service.IStudentService;
import dao.student_service.StudentService;
import model.Classroom;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassServlet", urlPatterns = "/class")
public class ClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createNewClass(request, response);
                break;
            default:
                displayClassRoom(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//        int ID = Integer.parseInt(request.getParameter("ID"));
        System.out.println("get class action" + action);
        switch (action) {
            case "showStudentInClass":
                showStudentInClass(request, response);
                break;
            default:
                displayClassRoom(request, response);
        }
    }

    private void showStudentInClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classID = Integer.parseInt(request.getParameter("ID"));
        IStudentService studentService = new StudentService();
        List<Student> students = studentService.getStudentInClass(classID);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/academicStaff/DisplayStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void displayClassRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roleLogin = (String) session.getAttribute("roleLogin");
        IClassroomService classroomService = new ClassroomService();
        List<Classroom> classrooms = classroomService.getAllClassroom();
        request.setAttribute("classrooms", classrooms);
        RequestDispatcher dispatcher;
        switch (roleLogin) {
            case "admin":
                dispatcher = request.getRequestDispatcher("view/admin/admin_displayClass.jsp");
                dispatcher.forward(request, response);
                break;
            case "academic_staff":
                dispatcher = request.getRequestDispatcher("view/academicStaff/DisplayClass.jsp");
                dispatcher.forward(request, response);
                break;
        }

    }

    private void createNewClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        Classroom classroom = new Classroom(className);
        IClassroomService classroomService = new ClassroomService();
        classroomService.createNewClassroom(classroom);
        response.sendRedirect("/login");
    }


}
