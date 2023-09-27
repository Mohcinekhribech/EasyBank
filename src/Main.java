import DAO.ClientDao;
import DAO.EmployeDao;
import DTO.Client;
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

        ClientDao clientDao = new ClientDao();
        List<Map<String , String>> clients = clientDao.showClients();
        for(int i = 0; i<clients.size();i++)
        for(String keys: clients.get(i).keySet()){
            System.out.println(keys+ " : "  +clients.get(i).get(keys));
        }
        //System.out.println(clientDao.delete("AZERTY"));
//        Client client = new Client();
//        client.setFirstName("Mohcine");
//        client.setLastName("Khribech");
//        client.setAdress("Agadir");
//        client.setCode("AZERTY");
//        client.setDateOfBirth(LocalDate.parse("2020-02-02"));
//        client.setPhoneNumber("0631560367");
//        clientDao.add(Optional.of(client));

//        EmployeDao em = new EmployeDao();
//        for(String keys: em.SearchByRegistrationNumber("121212").keySet()){
//            System.out.println(keys+ " : "  +em.SearchByRegistrationNumber("121212").get(keys));
//        }
    }
}