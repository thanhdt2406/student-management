package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowCreateClassFormServlet",urlPatterns = "/Class")
public class ShowCreateClassFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("action");
        System.out.println(str);

        request.setAttribute("action","content");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/Admin/sideBar.jsp");
        dispatcher.forward(request,response);
    }
}
