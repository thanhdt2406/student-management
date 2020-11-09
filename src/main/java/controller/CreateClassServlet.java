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

@WebServlet(name = "ClassServlet",urlPatterns = "/class")
public class CreateClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createNewClass(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        createNewClass(request,response);
    }

    private void createNewClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        Classroom classroom = new Classroom(className);
        IClassroomService classroomService = new ClassroomService();
        classroomService.createNewClassroom(classroom);
        response.sendRedirect("/login");
    }
}
