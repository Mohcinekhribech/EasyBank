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
    }
}