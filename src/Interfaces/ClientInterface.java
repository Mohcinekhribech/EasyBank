package Interfaces;

import DTO.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClientInterface {
    Optional<Client> add(Optional<Client> client) throws SQLException;
    int delete(String code);
    Client update(Client client,String code);
    List<Client> searchByCode(String code);
    List<Client> showClients();
}
