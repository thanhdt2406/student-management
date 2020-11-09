package controller;


import dao.user_service.UserService;
import model.staff.AcademicStaff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountInformationServlet",urlPatterns = "/accountInformation")
public class AccountInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int ID = (int) session.getAttribute("idLogin");
        String roleLogin = (String) session.getAttribute("roleLogin");

        switch (roleLogin){
            case "academic_staff":
                UserService userService = new UserService();
                AcademicStaff academicStaff = (AcademicStaff) userService.getUserInfor(ID);
                request.setAttribute("academic_staff",academicStaff);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/academicStaff/AS_ShowAccountInformation.jsp");
                requestDispatcher.forward(request,response);
                break;
        }
    }
}
