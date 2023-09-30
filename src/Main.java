import DAO.ClientDao;
import DAO.EmployeDao;
import DAO.MissionDao;
import DAO.OperationDao;
import DTO.*;
import DTO.Enum.OperationType;
import Helpers.Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

<<<<<<< HEAD
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
=======
        MissionDao missionDao = new MissionDao();
        System.out.println(missionDao.delete("1234"));
//        Operation operation = new Operation();
//        Account account = new Account();
//        Employee employee = new Employee();
//        account.setAccountNumber("1234566");
//        employee.setRegistrationNumber("121212");
//        operation.setAccount(account);
//        operation.setEmployee(employee);
//        operation.setPrice(10000);
//        operation.setDate(LocalDate.parse("2020-03-03"));
//        operation.setType(OperationType.payment);
        //System.out.println(operationDao.delete(2));

//        EmployeDao em = new EmployeDao();
//        for(String keys: operationDao.searchOperationByNum(3).keySet()){
//            System.out.println(keys+ " : "  +operationDao.searchOperationByNum(3).get(keys));
//        }
//    }
>>>>>>> f66a76699ac9e0d936354aba698588eb31cd60a2
    }
}