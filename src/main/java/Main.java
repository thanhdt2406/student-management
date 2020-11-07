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

        AcademicStaff as = new AcademicStaff("username1","ddd","name1","phonenumber1","address1",10000);


        //System.out.println(service.addNewAcademicStaff(as));
        service.deleteAS(15);
        System.out.println("lalala");

    }
}
