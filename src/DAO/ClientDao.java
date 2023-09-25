package DAO;

import DTO.Client;
import Helpers.Database;
import Interfaces.ClientInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientDao implements ClientInterface {
    Connection connection = Database.ConnectToDb();
    @Override
    public Optional<Client> add(Optional<Client> client) throws SQLException {
        if(client.isPresent()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO person (firstName, lastName, dateofbirth, phonenumber) VALUES (?, ?, ?, ?)");
            statement.setString(1, client.get().getFirstName());
            statement.setString(2, client.get().getLastName());
            statement.setDate(3, Date.valueOf(client.get().getDateOfBirth()));
            statement.setString(4, client.get().getPhoneNumber());
            if(statement.executeUpdate()>0)
            {
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO client (id, code , adress) VALUES ((SELECT id FROM person WHERE firstName = ? AND lastName = ? AND dateofbirth = ?), ?, ?)");
                statement1.setString(1, client.get().getFirstName());
                statement1.setString(2, client.get().getLastName());
                statement1.setDate(3, Date.valueOf(client.get().getDateOfBirth()));
                statement1.setString(4, client.get().getCode());
                statement1.setString(5, client.get().getAdress());
                if(statement1.executeUpdate()>0)
                {
                    connection.commit();
                    return client;
                }
            }
        }
        connection.rollback();
        return Optional.empty();
    }
    @Override
    public int delete(String code) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from person where id = (select id from client where code = ?)");
            statement.setString(1,code);
            return statement.executeUpdate();
        }catch(Exception e)
        {
            throw new RuntimeException();
        }
    }

    @Override
    public Client update(Client client, String code) {
        return null;
    }

    @Override
    public List<Client> searchByCode(String code) {
        return null;
    }

    @Override
    public List<Client> showClients() {
        return null;
    }
}
