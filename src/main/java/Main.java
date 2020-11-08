import dao.studentdiary_sevice.StudentDiaryService;
import dao.user_service.UserService;
import model.Student;
import model.diary.StudentDiary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ConnectDB connectDB = ConnectDB.getInstance();
//        Connection connection = connectDB.getConnection();

//        StudentDiaryService service = new StudentDiaryService();
//        StudentDiary diary = new StudentDiary("thang ngu nay", 2);
        //service.createNewStudentDiary(diary);
        //System.out.println(service.editStudentDiary(2,"pro"));
//        List<StudentDiary> list = service.getStudentDiary(2);
//        System.out.println(list.size());
//        for (StudentDiary ele : list){
//            System.out.println(ele.getContent());
//        }
//        service.deleteStudentDiary(4);
        UserService service = new UserService();
        Student student = (Student) service.getUserInfor(5);
        System.out.println(student.getSignUpDate());
    }
}
