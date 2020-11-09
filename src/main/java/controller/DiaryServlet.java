package controller;

import dao.classdiary_service.ClassDiaryService;
import dao.classdiary_service.IClassDiaryService;
import dao.studentdiary_sevice.IStudentDiaryService;
import dao.studentdiary_sevice.StudentDiaryService;
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

@WebServlet(name = "DiaryServlet", urlPatterns = "/diary")
public class DiaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("action post diaryservlet ");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action doget diaryservlet "+action);
        switch (action){
            case "displayAllClassDiary":
                displayClassDiary(request,response);
                break;
            case "displayAllStudentDiary":
                displayStudentDiary(request,response);
                break;
            case "create":
                createNewClassDiary(request,response);
                break;
            default:
        }
    }

    private void createNewClassDiary(HttpServletRequest request, HttpServletResponse response) {
    String type = request.getParameter("type");
    switch (type){
        case "class":
            System.out.println("class tyoe");
            ClassDiaryService service = new ClassDiaryService();
            String content = request.getParameter("content");
            System.out.println("classID: "+request.getParameter("classId"));
            System.out.println(content);
            int classID = Integer.parseInt(request.getParameter("classId"));
            System.out.println("classiD"+classID);
            boolean rs = service.createNewClassDiary(new ClassDiary(content,classID));
            System.out.println("create class diary "+rs);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/diary?action=displayAllClassDiary");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        case "student":
            break;
        default:
    }
    }

    private void displayStudentDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentDiaryService studentDiaryService = new StudentDiaryService();
        List<StudentDiary> diaryList =  studentDiaryService.getAllStudentDiary();
        request.setAttribute("diaryList",diaryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/academicStaff/DisplayStudentDiary.jsp");
        requestDispatcher.forward(request,response);
    }

    private void displayClassDiary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassDiaryService classDiaryService = new ClassDiaryService();
        List<ClassDiary> classDiaryList =  classDiaryService.getAllClassDiary();
        request.setAttribute("diaryList",classDiaryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/academicStaff/DisplayClassDiary.jsp");
        requestDispatcher.forward(request,response);
    }

}
