import DAO.*;
import DTO.*;
import DTO.Enum.Status;
import Helpers.Database;
import Services.AccountServices.AccountService;
import Services.AccountServices.CurrentAccountService;
import Services.AccountServices.SavingAccountService;
import Services.ClientService;
import Services.EmployeeService;
import Services.OperationService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService= new EmployeeService(new Employee(),new EmployeDao());
        ClientService clientService = new ClientService(new Client(),new ClientDao());
        AccountService accountService = new AccountService(new AccountDao(),new Account());
        OperationService operationService = new OperationService(new Operation(),new OperationDao());
        int choice ;
        System.out.println("-----------------------------------------------------------------");
        System.out.println(". 1 - Administre les employés    2 - Adminidtrer les clients    .");
        System.out.println(".                                                               .");
        System.out.println(". 3 - Administre les comptes     4 - Adminidtrer les operations .");
        System.out.println(".                                                               .");
        System.out.println(". 5 - Administre les missions                                   .");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("entrer votre chois : ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1 : employeeService.menu();
            break;
            case 2 : clientService.menu();
            break;
            case 3 : accountService.menu();
            break;
            case 4 : operationService.menu();
            break;

        }
       // EmployeDao em = new EmployeDao();
        //Employee empl = new Employee();
        //empl.setFirstName("Mohcine");
        //empl.setEmail("mohcinekhribche123@gmail.com");
        //empl.setRecruitmentDate(LocalDate.parse("2023-01-15"));
        //empl.setDateOfBirth(LocalDate.parse("2023-01-15"));
        //empl.setPhoneNumber("09876543");
        //empl.setLastName("khribech");
        //em.update(empl,"121212");

//        List<Map<String,String>> employes= em.Search(empl);
//        for (int i=0 ; i<employes.size();i++)
//        for(String keys: employes.get(i).keySet()){
//            System.out.println(keys+ " : "  +employes.get(i).get(keys));
//        }
 //       MissionDao missionDao = new MissionDao();
 //       System.out.println(missionDao.delete("1234"));
//        MissionDao missionDao = new MissionDao();
//        System.out.println(missionDao.delete("1234"));
//        ClientDao clientDao = new ClientDao();
 //       //Client client = new Client();
 //       SavingAccountDao savingAccount = new SavingAccountDao();
 //       AccountDao accountDao = new AccountDao();

        //System.out.println(accountDao.changeState("1234566", String.valueOf(Status.active)));
        //System.out.println(accountDao.delete("1234567"));
   //     List<Map<String,String>> mapList = accountDao.showByCreationDate(LocalDate.parse("2020-04-20"));
   //     for(int i=0 ; i<mapList.size() ;i++)
   //     {
   //         for(String keys: mapList.get(i).keySet()){
   //        System.out.println(keys+ " : "  +mapList.get(i).get(keys));
   //         }
   //     }
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
//        ClientDao clientDao = new ClientDao();
//        List<Map<String , String>> clients = clientDao.showClients();
//        for(int i = 0; i<clients.size();i++)
//        for(String keys: clients.get(i).keySet()){
//            System.out.println(keys+ " : "  +clients.get(i).get(keys));
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
 //       MissionDao missionDao = new MissionDao();
 //       System.out.println(missionDao.delete("1234"));
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

//        Mission mission = new Mission();
//        mission.setDescription("test");
//        mission.setName("test");
//        mission.setCode("123456");
        MissionDao em = new MissionDao();
//        em.add(mission);
        List<Map<String,String>> missions = em.getAll();
        for(int i =0;i<missions.size();i++)
        for(String keys: missions.get(i).keySet()){
            System.out.println(keys+ " : "  +missions.get(i).get(keys));
        }
//    }
    }
}