package controller;

import dao.academic_service.AcademicService;
import dao.classdiary_service.ClassDiaryService;
import dao.classroom_service.ClassroomService;
import dao.classroom_service.IClassroomService;
import dao.student_service.StudentService;
import dao.teacher_service.TeacherService;
import dao.user_service.UserService;
import model.Classroom;
import model.Student;
import model.User;
import model.diary.ClassDiary;
import model.staff.AcademicStaff;
import model.staff.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowCreateClassFormServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createClass":
                createNewClass(request, response);
                break;
            case "createNewTeacher":
                createNewTeacher(request, response);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin_createNewTeacher.jsp");
                dispatcher.forward(request, response);
                break;
            case "createNewAs":
                createNewAs(request, response);
                dispatcher = request.getRequestDispatcher("/view/admin/admin_createNewStaff.jsp");
                dispatcher.forward(request, response);
                break;
            case "createNewStudent":
                createNewStudent(request, response);
                dispatcher = request.getRequestDispatcher("/view/admin/admin_createNewStudent.jsp");
                dispatcher.forward(request, response);
                break;
            default:
        }
    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        int classId = Integer.parseInt(request.getParameter("className"));

        System.out.println(classId);
        StudentService service = new StudentService();
        boolean rs = service.addNewStudent(new Student(username, password, name, address, phone, classId));
        if (rs) {
            request.setAttribute("message", "add student success!");
            System.out.println("add success!");
        } else {
            request.setAttribute("message", " ");
        }
    }

    private void createNewTeacher(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("adminpost create teacher");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        int salary = Integer.parseInt(request.getParameter("salary"));

        TeacherService service = new TeacherService();
        boolean rs = service.addNewTeacher(new Teacher(username, password, name, address, phone, salary));
        if (rs) {
            request.setAttribute("message", "add teacher success!");
            System.out.println("add success!");
        } else {
            request.setAttribute("message", " ");
        }
    }

    private void createNewAs(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("adminpost create acastaff");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        int salary = Integer.parseInt(request.getParameter("salary"));

        AcademicService service = new AcademicService();
        boolean rs = service.addNewAcademicStaff(new AcademicStaff(username, password, name, address, phone, salary));
        if (rs) {
            request.setAttribute("message", "add Academic staff success!");
            System.out.println("add success!");
        } else {
            request.setAttribute("message", " ");
        }
    }

    private void createNewClass(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createClass":
                createClassForm(request, response);
                break;
            case "createNewTeacher":
                createNewTeacherForm(request, response);
                break;
            case "createNewAs":
                createNewAsForm(request, response);
                break;
            case "createNewStudent":
                createNewStudentForm(request, response);
                break;
            case "displayClass":
                RequestDispatcher dispatcher = request.getRequestDispatcher("/class");
                dispatcher.forward(request,response);
                break;
            case "listAs":
                listAllAs(request, response);
                break;
            case "listTeacher":
                listAllTeacher(request, response);
                break;
            case "listStudent":
                listAllStudent(request, response);
                break;
            case "listUser":
                listAllUser(request, response);

                break;
            default:
        }
    }

    private void listAllTeacher(HttpServletRequest request, HttpServletResponse response) {
        TeacherService service = new TeacherService();
        List<Teacher> list = service.showAllTeacher();
        request.setAttribute("listTeacher",list);
        System.out.println(list.size());
        System.out.println(list.get(1).getName());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin_listTeacher.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listAllAs(HttpServletRequest request, HttpServletResponse response) {
        AcademicService service = new AcademicService();
        List<AcademicStaff> list = service.listAcademicStaff();
        request.setAttribute("listAs",list);
        System.out.println(list.size());
                System.out.println(list.get(1).getName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin_listStaff.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listAllStudent(HttpServletRequest request, HttpServletResponse response) {
        StudentService service = new StudentService();
        List<Student> list = service.getAllStudent();
        request.setAttribute("listStudent",list);
        System.out.println(list.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin_listStudent.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listAllUser(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createNewTeacherForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewTeacher.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewAsForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewStaff.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewStudentForm(HttpServletRequest request, HttpServletResponse response) {
        ClassroomService service = new ClassroomService();
        List<Classroom> list = service.getAllClassroom();
        request.setAttribute("listClass", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createNewStudent.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createClassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createClassForm.jsp");
        dispatcher.forward(request, response);
    }
}
