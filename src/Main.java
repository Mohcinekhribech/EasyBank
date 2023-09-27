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
        List<Map<String,String>> employes= em.getAll();
        for (int i=0 ; i<employes.size();i++)
        for(String keys: employes.get(i).keySet()){
            System.out.println(keys+ " : "  +employes.get(i).get(keys));
        }
    }
}