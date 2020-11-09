package controller;

import dao.classdiary_service.ClassDiaryService;
import dao.classroom_service.ClassroomService;
import dao.classroom_service.IClassroomService;
import dao.student_service.StudentService;
import dao.teacher_service.TeacherService;
import model.Classroom;
import model.diary.ClassDiary;
import model.staff.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowCreateClassFormServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        switch (action){
            case "createClass":
                createNewClass(request,response);
                break;
            case "createNewTeacher":
                createNewTeacher(request,response);
                request.setAttribute("message","add new teacher success!");
                RequestDispatcher dispatcher =request.getRequestDispatcher("");
                dispatcher.forward(request,response);
                break;
            case "createNewAs":
                createNewAs(request,response);
                break;
            case "createNewStudent":
                createNewStudent(request,response);
                break;
            default:
        }
    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        int classId = Integer.parseInt(request.getParameter("className"));

        System.out.println(classId);

        StudentService service = new StudentService();
      //doing...
    }
    private void createNewTeacher(HttpServletRequest request, HttpServletResponse response) {
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        int salary = Integer.parseInt(request.getParameter("salary"));

        TeacherService service = new TeacherService();
        service.addNewTeacher(new Teacher(username,password,name,address,phone,salary));
    }
    private void createNewAs(HttpServletRequest request, HttpServletResponse response) {
    }
    private void createNewClass(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        switch (action){
            case "createClass":
                createClassForm(request,response);
                break;
            case "createNewTeacher":
                createNewTeacherForm(request,response);
                break;
            case "createNewAs":
                createNewAsForm(request,response);
                break;
            case "createNewStudent":
                createNewStudentForm(request,response);
                break;
            case "displayClass":
                request.setAttribute("action","");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/class");
                requestDispatcher.forward(request,response);
                break;
            default:
        }
    }

    private void createNewTeacherForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewTeacher.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createNewAsForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewStaff.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createNewStudentForm(HttpServletRequest request, HttpServletResponse response) {
        ClassroomService service = new ClassroomService();
        List<Classroom> list = service.getAllClassroom();
        request.setAttribute("listClass",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewStudent.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createClassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createClassForm.jsp");
        dispatcher.forward(request,response);
    }
}
