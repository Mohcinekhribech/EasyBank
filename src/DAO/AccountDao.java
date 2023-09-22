package DAO;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;
import Interfaces.AccountInterface;

import java.util.Date;
import java.util.List;

public class AccountDao implements AccountInterface {
    @Override
    public Account add(Account account) {
        return null;
    }

    @Override
    public int delete(String accNum) {
        return 0;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public List<Account> showByCreationDate(Date creationDate) {
        return null;
    }

    @Override
    public List<Account> showByStatus(Status status) {
        return null;
    }

    @Override
    public List<Account> show() {
        return null;
    }

    @Override
    public boolean changeState(String accNum) {
        return false;
    }

    @Override
    public List<Account> searchByClient(Client client) {
        return null;
    }
}
