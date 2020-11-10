package controller;

import dao.classdiary_service.ClassDiaryService;
import dao.classdiary_service.IClassDiaryService;
import dao.classroom_service.ClassroomService;
import dao.student_service.StudentService;
import dao.studentdiary_sevice.IStudentDiaryService;
import dao.studentdiary_sevice.StudentDiaryService;
import model.Classroom;
import model.Student;
import model.diary.ClassDiary;
import model.diary.StudentDiary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherServlet", urlPatterns = "/teacher")
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "listStudent":
                listAllStudent(request, response);
                break;
            case "listClass":
                break;
            case "listClassDiary":
                displayClassDiary(request, response);
                break;
            case "listStudentDiary":
                displayStudentDiary(request, response);
                break;
            case "createClassDiary":
                createClassDiaryForm(request,response);
                break;
            case "createTeacherDiary":
                createStudentDiaryForm(request,response);
                break;
            default:
        }
    }

    private void createStudentDiaryForm(HttpServletRequest request, HttpServletResponse response) {
        StudentService service = new StudentService();
        List<Student> list = service.getAllStudent();
        request.setAttribute("listStudent",list);
        System.out.println(list.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin_createStudentDiaryForm.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createClassDiaryForm(HttpServletRequest request, HttpServletResponse response) {
        ClassroomService service = new ClassroomService();
        List<Classroom> list = service.getAllClassroom();
        request.setAttribute("listClass",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/admin_createClassDiaryForm.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayClassDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassDiaryService classDiaryService = new ClassDiaryService();
        List<ClassDiary> classDiaryList =  classDiaryService.getAllClassDiary();
        request.setAttribute("diaryList",classDiaryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/admin_displayClassDiary.jsp");
        requestDispatcher.forward(request,response);
    }
    private void displayStudentDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentDiaryService studentDiaryService = new StudentDiaryService();
        List<StudentDiary> diaryList =  studentDiaryService.getAllStudentDiary();
        request.setAttribute("diaryList",diaryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/admin_displayStudentDiary.jsp");
        requestDispatcher.forward(request,response);
    }

    private void listAllStudent(HttpServletRequest request, HttpServletResponse response) {
        StudentService service = new StudentService();
        List<Student> list = service.getAllStudent();
        request.setAttribute("listStudent", list);
        System.out.println(list.size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/teacher_listStudent.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
