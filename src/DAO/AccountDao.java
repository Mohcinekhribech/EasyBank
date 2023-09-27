package DAO;

import DTO.Account;
import DTO.Client;
import DTO.Enum.Status;
import Helpers.Database;
import Interfaces.AccountInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public List<Map<String , String>> showByStatus(Status status) {
        Map<String,String> account = new HashMap<>();
        List<Map<String,String>> accounts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account where status = ?::status;");
            statement.setString(1, String.valueOf(status));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                account.put("accountNumber",resultSet.getString("accountNumber"));
                account.put("balance", String.valueOf(resultSet.getDouble("balance")));
                account.put("creationDate",resultSet.getString("creationDate"));
                account.put("client_code",resultSet.getString("client_code"));
                account.put("status",resultSet.getString("status"));
                accounts.add(account);
            }
            return accounts;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Map<String, String>> show() {
        Map<String,String> account = new HashMap<>();
        List<Map<String,String>> accounts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account ;");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                account.put("accountNumber",resultSet.getString("accountNumber"));
                account.put("balance", String.valueOf(resultSet.getDouble("balance")));
                account.put("creationDate",resultSet.getString("creationDate"));
                account.put("client_code",resultSet.getString("client_code"));
                account.put("status",resultSet.getString("status"));
                accounts.add(account);
            }
            return accounts;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changeState(String accNum,String status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update account set status = ?::status");
        statement.setString(1, String.valueOf(status));
        return statement.executeUpdate()>0;
    }

    @Override
    public List<Map<String, String>> searchByClient(String clientCode) {
        return null;
    }


}
