//package controller;
//import dao.admin_service.AdminService;
//import model.User;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        RequestDispatcher dispatcher = null;
//        String url = "/view/StudentIndex.jsp";
//        User user = new AdminService().login(username, password);
//        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//            session.setAttribute("username", username);
//            session.setAttribute("password", password);
//            String role = user.getRole();
//            switch (role) {
//                case "admin":
//                    url ="/view/AdminIndex.jsp";
//                    break;
//                case "academic_staff":
//                    url = "/view/AcademicStaffIndex.jsp";
//                    break;
//                case "teacher":
//                    url = "/view/TeacherIndex.jsp";
//                    break;
//            }
//            dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        }
//    }
//}
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
        RequestDispatcher dispatcher = null;
        List<User> userList = adminService.getAllUsers();
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                if(user.getRole().equals("admin")){
                     dispatcher = request.getRequestDispatcher("/view/AdminIndex.jsp");
                    break;
                } else if(user.getRole().equals("academic_staff")){
                    dispatcher = request.getRequestDispatcher("/view/AcademicStaffIndex.jsp");
                    break;
                } else if(user.getRole().equals("teacher")){
                   response.sendRedirect("teachers");
                    break;
                } else {
                    dispatcher = request.getRequestDispatcher("/view/StudentIndex.jsp");
                    break;
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
