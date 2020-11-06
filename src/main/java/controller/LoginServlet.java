package controller;

import dao.admin_service.AdminService;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminService();
        List<User> userList = adminService.getAllUsers();
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                if(user.getRole().equals("admin")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/AdminIndex.jsp");
                    dispatcher.forward(request, response);
                } else if(user.getRole().equals("academic_staff")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/AcademicStaffIndex.jsp");
                    dispatcher.forward(request, response);
                } else if(user.getRole().equals("teacher")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/TeacherIndex.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/StudentIndex.jsp");
                    dispatcher.forward(request, response);
                }
                return;
            }
        }
        response.sendRedirect(request.getContextPath() + "/view/login.jsp?error=0");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response   ) throws ServletException, IOException {

    }
}
