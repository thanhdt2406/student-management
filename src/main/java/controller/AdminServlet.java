package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowCreateClassFormServlet",urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if (fileName.equals("AdminIndex")){
            fileName = "ListUser";
        }
        request.setAttribute("fileNameRes",fileName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/AdminIndex.jsp");
        dispatcher.forward(request,response);
    }
}
