import dao.studentdiary_sevice.StudentDiaryService;
import dao.teacher_service.TeacherService;
import dao.user_service.UserService;
import model.Student;
import model.diary.StudentDiary;
import model.staff.Teacher;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeacherService service = new TeacherService();
        boolean rs = service.addNewTeacher(new Teacher("username","password","name","address","phonenumber",11111));
        System.out.println(rs);
    }
}
