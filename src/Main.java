import DAO.EmployeDao;
import DTO.Employee;
import Helpers.Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        EmployeDao em = new EmployeDao();
        Employee empl = new Employee();
        empl.setFirstName("Mohcine");
        empl.setEmail("mohcinekhribche123@gmail.com");
        empl.setRecruitmentDate(LocalDate.parse("2023-01-15"));
        empl.setDateOfBirth(LocalDate.parse("2023-01-15"));
        empl.setPhoneNumber("09876543");
        empl.setLastName("khribech");
        em.update(empl,"121212");

//        List<Map<String,String>> employes= em.Search(empl);
//        for (int i=0 ; i<employes.size();i++)
//        for(String keys: employes.get(i).keySet()){
//            System.out.println(keys+ " : "  +employes.get(i).get(keys));
//        }
    }
}