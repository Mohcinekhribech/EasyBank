import DAO.*;
import DTO.*;
import DTO.Enum.Status;
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
        //Client client = new Client();
        SavingAccountDao savingAccount = new SavingAccountDao();
        AccountDao accountDao = new AccountDao();

        //System.out.println(accountDao.changeState("1234566", String.valueOf(Status.active)));
        //System.out.println(accountDao.delete("1234567"));
        List<Map<String,String>> mapList = accountDao.showByCreationDate(LocalDate.parse("2020-04-20"));
        for(int i=0 ; i<mapList.size() ;i++)
        {
            for(String keys: mapList.get(i).keySet()){
           System.out.println(keys+ " : "  +mapList.get(i).get(keys));
            }
        }
//        CurrentAccountDao currentAccountDao = new CurrentAccountDao();
//        CurrentAccount currentAccount = new CurrentAccount();
//        currentAccount.setAccountNumber("1234566");
//        currentAccount.setBalance(2000);
//        currentAccount.setCreationDate(LocalDate.parse("2020-04-20"));
//        currentAccount.setMaxPrice(20000);
//        client.setCode("AZERTY");
//        currentAccount.setClient(client);
//        currentAccount.setStatus(Status.active);
//        currentAccountDao.add(Optional.of(currentAccount));
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