package DAO;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;
import DTO.SavingAccount;
import Helpers.Database;
import Interfaces.AccountInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SavingAccountDao implements AccountInterface<SavingAccount> {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<SavingAccount> add(Optional<SavingAccount> account) throws SQLException {
        if(account.isPresent()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO account (accountNumber, balance, creationDate, client_code,status) VALUES (?, ?, ?, ?,?::status)");
            statement.setString(1, account.get().getAccountNumber());
            statement.setDouble(2, account.get().getBalance());
            statement.setDate(3, java.sql.Date.valueOf(account.get().getCreationDate()));
            statement.setString(4,account.get().getClient().getCode());
            statement.setString(5, String.valueOf(account.get().getStatus()));
            if(statement.executeUpdate()>0)
            {
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO SavingAccount (id, interestrate) VALUES ((SELECT accountNumber FROM account WHERE accountNumber = ? ), ?)");
                statement1.setString(1, account.get().getAccountNumber());
                statement1.setDouble(2, account.get().getInterestRate());
                if(statement1.executeUpdate()>0)
                {
                    connection.commit();
                    return account;
                }
            }
        }
        connection.rollback();
        return Optional.empty();
    }

    @Override
    public int delete(String accNum) {
        return 0;
    }

    @Override
    public Optional<SavingAccount> update(Optional<SavingAccount> account) {
        return Optional.empty();
    }

    @Override
    public List<Optional<SavingAccount>> showByCreationDate(Date creationDate) {
        return null;
    }

    @Override
    public List<Optional<SavingAccount>> showByStatus(Status status) {
        return null;
    }

    @Override
    public List<Optional<SavingAccount>> show() {
        return null;
    }

    @Override
    public boolean changeState(String accNum) {
        return false;
    }

    @Override
    public List<SavingAccount> searchByClient(Client client) {
        return null;
    }
}
