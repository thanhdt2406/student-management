package controller;

import dao.classroom_service.ClassroomService;
import dao.classroom_service.IClassroomService;
import model.Classroom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassServlet",urlPatterns = "/class")
public class ClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createNewClass(request,response);
                break;
            default:
                displayClassRoom(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
//        int ID = Integer.parseInt(request.getParameter("ID"));
        System.out.println("get class action"+action);
        switch (action){
            case "edit":
            break;
            default:
                displayClassRoom(request,response);
        }
    }

    private void displayClassRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassroomService classroomService = new ClassroomService();
        List<Classroom> classrooms = classroomService.getAllClassroom();
        System.out.println(classrooms.size());
        request.setAttribute("classrooms",classrooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_displayClass.jsp");
        dispatcher.forward(request,response);
    }

    private void createNewClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        Classroom classroom = new Classroom(className);
        IClassroomService classroomService = new ClassroomService();
        classroomService.createNewClassroom(classroom);
        response.sendRedirect("/login");
    }


}
