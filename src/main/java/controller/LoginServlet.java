package controller;

import dao.user_service.UserService;
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
        HttpSession session = request.getSession(true);
        if(session.getAttribute("roleLogin")!=null){
            if(session.getAttribute("roleLogin").equals("admin")){
                request.setAttribute("fileNameRes","ListUser");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/AdminIndex.jsp");
                dispatcher.forward(request, response);
            } else if(session.getAttribute("roleLogin").equals("academic_staff")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/academicStaff/AcademicStaffIndex.jsp");
                dispatcher.forward(request, response);
            }else if(session.getAttribute("roleLogin").equals("teacher")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/teacher/TeacherIndex.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/student/StudentIndex.jsp");
                dispatcher.forward(request, response);
            }
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        List<User> userList = userService.getAllUser();
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("roleLogin", user.getRole());
                session.setAttribute("idLogin", user.getUserId());
                if(user.getRole().equals("admin")){
                    request.setAttribute("fileNameRes","ListUser");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/AdminIndex.jsp");
                    dispatcher.forward(request, response);
                } else if(user.getRole().equals("academic_staff")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/academicStaff/AcademicStaffIndex.jsp");
                    dispatcher.forward(request, response);
                } else if(user.getRole().equals("teacher")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Teacher/TeacherIndex.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Student/StudentIndex.jsp");
                    dispatcher.forward(request, response);
                }
                return;
            }
        }
        response.sendRedirect(request.getContextPath() + "/view/login.jsp?error=0");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response   ) throws ServletException, IOException {
        doPost(request,response);
    }
}
