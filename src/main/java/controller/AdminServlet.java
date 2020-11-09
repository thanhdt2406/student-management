package controller;

import dao.classdiary_service.ClassDiaryService;
import dao.classroom_service.ClassroomService;
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

@WebServlet(name = "ShowCreateClassFormServlet",urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        System.out.println(request.getParameter("action"));
        System.out.println(action);
        switch (action){
            case "createDiaryForm":
                System.out.println("create");
                showCreateDiaryClassForm(request,response);
                break;
            case "createNewClass":
                System.out.println("create new class form");
                showCreateNewClassForm(request,response);
            default:
        }
    }

    private void showCreateNewClassForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("fileNameRes", "CreateClassForm");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/AdminIndex.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateDiaryClassForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("fileNameRes", "createDiaryForm");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/AdminIndex.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
