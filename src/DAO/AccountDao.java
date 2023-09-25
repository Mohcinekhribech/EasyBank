package DAO;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;
import Helpers.Database;
import Interfaces.AccountInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AccountDao implements AccountInterface<Account>{
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<Account> add(Optional<Account> account){return Optional.empty();} ;

    @Override
    public int delete(String accNum) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from account where accountNumber = ?");
            statement.setString(1,accNum);
            return statement.executeUpdate();
        }catch(Exception e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Account> update(Optional<Account> account) {
        return Optional.empty();
    }

    @Override
    public List<Optional<Account>> showByCreationDate(Date creationDate) {
        return null;
    }

    @Override
    public List<Optional<Account>> showByStatus(Status status) {
        return null;
    }

    @Override
    public List<Optional<Account>> show() {
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
