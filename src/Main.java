import DAO.ClientDao;
import DAO.CurrentAccountDao;
import DAO.EmployeDao;
import DAO.SavingAccountDao;
import DTO.Client;
import DTO.CurrentAccount;
import DTO.Employee;
import DTO.Enum.Status;
import DTO.SavingAccount;
import Helpers.Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        ClientDao clientDao = new ClientDao();
        Client client = new Client();
        CurrentAccountDao currentAccountDao = new CurrentAccountDao();
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber("1234566");
        currentAccount.setBalance(2000);
        currentAccount.setCreationDate(LocalDate.parse("2020-04-20"));
        currentAccount.setMaxPrice(20000);
        client.setCode("AZERTY");
        currentAccount.setClient(client);
        currentAccount.setStatus(Status.active);
        currentAccountDao.add(Optional.of(currentAccount));
//        for(String keys: clientDao.searchByCode("AZERTY").keySet()){
//            System.out.println(keys+ " : "  +clientDao.searchByCode("AZERTY").get(keys));
//        }
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