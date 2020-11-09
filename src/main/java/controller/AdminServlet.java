package controller;

import dao.classdiary_service.ClassDiaryService;
import dao.classroom_service.ClassroomService;
import dao.classroom_service.IClassroomService;
import model.Classroom;
import model.diary.ClassDiary;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        System.out.println(request.getParameter("action"));
        System.out.println(action);
        switch (action){
            case "createClass":
                createClassForm(request,response);
                break;
            case "displayClass":
                request.setAttribute("action","");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/class");
                requestDispatcher.forward(request,response);
                break;
            default:
        }
    }

    private void showCreateNewClassForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("fileNameRes", "CreateClassForm");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/class");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createClassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("fileNameRes","CreateClassForm");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/AdminIndex.jsp");
        dispatcher.forward(request,response);
    }
}
