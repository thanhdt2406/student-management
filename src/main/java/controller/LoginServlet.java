package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        for (User user : userDAO.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                if(user.getRole().equals("admin")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/AdminIndex.jsp");
                    dispatcher.forward(request, response);
                } else if(user.getRole().equals("student"))
                return;
            }
        }
        response.sendRedirect(request.getContextPath() + "/view/login.jsp?error=0");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
