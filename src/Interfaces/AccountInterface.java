package Interfaces;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;

import java.util.Date;
import java.util.List;

public interface AccountInterface {
    Account add(Account account);
    int delete(String accNum);
    Account update(Account account);
    List<Account> showByCreationDate(Date creationDate);
    List<Account> showByStatus(Status status);
    List<Account> show();
    boolean changeState(String accNum);
    List<Account> searchByClient(Client client);
}
