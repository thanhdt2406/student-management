import dao.ConnectDB;
import dao.academic_service.AcademicService;
import dao.subject_service.SubjectService;
import model.Subject;
import model.staff.AcademicStaff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ConnectDB connectDB = ConnectDB.getInstance();
//        Connection connection = connectDB.getConnection();

        SubjectService service = new SubjectService();
        Subject subject = new Subject("C++");
        service.editSubject(1,"Java");
        service.editSubject(2,"C++");
        System.out.println(service.editSubject(6,"ssdsds"));

    }
}
