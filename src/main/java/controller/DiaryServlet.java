package controller;

import dao.classdiary_service.ClassDiaryService;
import model.diary.ClassDiary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiaryServlet", urlPatterns = "/diary")
public class DiaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        switch (type){
            case "class":
                classDiaryAction(action,content);
                break;
            case "student":
                studentDiaryAction(action,content);
                break;
            default:
        }
    }

    private void classDiaryAction(String action,String context) {
        ClassDiaryService service = new ClassDiaryService();
//        ClassDiary classDiary = new ClassDiary(context,)
//        service.createNewClassDiary(classDiary)
    }

    private void studentDiaryAction(String action,String context) {
    }
}
