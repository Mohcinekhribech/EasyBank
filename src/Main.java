import DAO.EmployeDao;
import DTO.Employee;
import Helpers.Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        EmployeDao em = new EmployeDao();
        System.out.println(em.delete("33333"));
    }
}