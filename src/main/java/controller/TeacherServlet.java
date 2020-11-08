package controller;

import dao.teacher_service.TeacherService;
import model.Classroom;
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

@WebServlet(name = "TeacherServlet", urlPatterns = {"/teachers"})
public class TeacherServlet extends HttpServlet {
     TeacherService teacherService = new TeacherService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher = null;
        action = action == null? "": action;
       switch (action){
           case "classIndex":
               dispatcher = request.getRequestDispatcher("/view/ClassIndex.jsp");
               List<Classroom> classRooms =  teacherService.getClassRoom();
               request.setAttribute("classRooms",classRooms);
               break;
           default:
               List<Teacher> teachers =  teacherService.showAllTeacher();
               request.setAttribute("teachers",teachers);
               dispatcher = request.getRequestDispatcher("/view/TeacherIndex.jsp");
               break;
       }
       dispatcher.forward(request, response);
    }
}
