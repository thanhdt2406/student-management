package controller;

import dao.academic_service.AcademicService;
import dao.academic_service.IAcademicService;
import dao.student_service.IStudentService;
import dao.student_service.StudentService;
import dao.user_service.IUserService;
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

@WebServlet(name = "EditAccountServlet", urlPatterns = "/editAccount")
public class EditAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roleLogin = (String) session.getAttribute("roleLogin");
        switch (roleLogin) {
            case "academic_staff":
                editAcademicStaffAccount(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int ID = (int) session.getAttribute("idLogin");
        String roleLogin = (String) session.getAttribute("roleLogin");
        String action = request.getParameter("action");
        switch (action) {
            case "editAccount":
                switch (roleLogin) {
                    case "academic_staff":
                        IUserService userService = new UserService();
                        AcademicStaff academicStaff = (AcademicStaff) userService.getUserInfor(ID);
                        request.setAttribute("academic_staff", academicStaff);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/academicStaff/EditAccountForm.jsp");
                        requestDispatcher.forward(request, response);
                        break;
                }
                break;
            case "editStudentAccount":
                switch (roleLogin){
                    case "academic_staff":
                        int id = Integer.parseInt(request.getParameter("ID"));
                        IStudentService studentService = new StudentService();
                        studentService.changeStatus(id);
                        response.sendRedirect("/accountInformation");
                }
        }

    }

    public void editAcademicStaffAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int ID = (int) session.getAttribute("idLogin");
        IAcademicService academicService = new AcademicService();
        String name = request.getParameter("newName");
        String address = request.getParameter("newAddress");
        String phoneNumber = request.getParameter("newPhoneNumber");
        String stt = request.getParameter("status");
        boolean status = false;
        if (stt.equals("true")) {
            status = true;
        }
        boolean rs = academicService.editAS(ID, name, phoneNumber, address, status);
        System.out.println(rs);
        response.sendRedirect("/accountInformation");
    }
}
