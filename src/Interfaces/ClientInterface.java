package Interfaces;

import DTO.Client;

import java.util.List;

public interface ClientInterface {
    Client add(Client client);
    int delete(String code);
    Client update(Client client,String code);
    List<Client> searchByCode(String code);
    List<Client> showClients();
}
