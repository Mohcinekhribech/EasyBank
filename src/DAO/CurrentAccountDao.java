package DAO;

import DTO.Client;
import DTO.CurrentAccount;
import DTO.Enum.Status;
import Helpers.Database;
import Interfaces.AccountInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CurrentAccountDao implements AccountInterface<CurrentAccount> {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<CurrentAccount> add(Optional<CurrentAccount> account) throws SQLException {
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
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO currentAccount (id, maxPrice) VALUES ((SELECT accountNumber FROM account WHERE accountNumber = ? ), ?)");
                statement1.setString(1, account.get().getAccountNumber());
                statement1.setDouble(2, account.get().getMaxPrice());
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
    public Optional<CurrentAccount> update(Optional<CurrentAccount> account) {
        return Optional.empty();
    }

    @Override
    public List<Optional<CurrentAccount>> showByCreationDate(Date creationDate) {
        return null;
    }

    @Override
    public List<Optional<CurrentAccount>> showByStatus(Status status) {
        return null;
    }

    @Override
    public List<Optional<CurrentAccount>> show() {
        return null;
    }

    @Override
    public boolean changeState(String accNum) {
        return false;
    }

    @Override
    public List<CurrentAccount> searchByClient(Client client) {
        return null;
    }
}
