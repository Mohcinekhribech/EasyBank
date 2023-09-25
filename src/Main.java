import DAO.EmployeDao;
import DTO.Employee;
import Helpers.Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        Optional<Employee> empl = Optional.of(new Employee());
        empl.get().setFirstName("edeuhdueh");
        empl.get().setLastName("bbbjdiejdeijdbb");
        empl.get().setDateOfBirth(LocalDate.parse("2023-03-03"));
        empl.get().setPhoneNumber("06772527");
        empl.get().setRecruitmentDate(LocalDate.parse("2023-03-03"));
        empl.get().setRegistrationNumber("121212");
        empl.get().setEmail("ASASA@email.com");
        EmployeDao em = new EmployeDao();
        Optional<Employee> emm = em.add(empl);
        System.out.println(emm.get().getEmail());
    }
}