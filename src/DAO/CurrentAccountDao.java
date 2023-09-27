package DAO;

import DTO.Client;
import DTO.CurrentAccount;
import DTO.Enum.Status;
import Helpers.Database;
import Interfaces.AccountInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public List<Map<String , String>> show() {
        return null;
    }

    @Override
    public boolean changeState(String accNum,String status) {
        return false;
    }

    @Override
    public List<Map<String,String>> searchByClient(String clientCode) {
        Map<String,String> client = new HashMap<>();
        List<Map<String,String>> clients = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account AS acc INNER JOIN currentAccount as curr ON curr.id = acc.accountNumber  where acc.client_code = ?;");
            statement.setString(1,clientCode);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                client.put("accountNumber",resultSet.getString("accountNumber"));
                client.put("balance",resultSet.getString("balance"));
                client.put("creationDate",resultSet.getString("creationDate"));
                client.put("client_code",resultSet.getString("client_code"));
                client.put("status",resultSet.getString("status"));
                client.put("maxPrice",resultSet.getString("maxPrice"));
                clients.add(client);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return clients;
    }
}
