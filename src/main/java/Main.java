import dao.ConnectDB;
import dao.academic_service.AcademicService;
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

        AcademicService service = new AcademicService();

        AcademicStaff as = new AcademicStaff("username","password","name","phonenumber","address",10000);


        System.out.println(service.addNewAcademicStaff(as));
        System.out.println("lalala");

    }
}
