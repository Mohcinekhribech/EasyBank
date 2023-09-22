package DAO;

import DTO.Client;
import Interfaces.ClientInterface;

import java.util.List;

public class ClientDao implements ClientInterface {
    @Override
    public Client add(Client client) {
        return null;
    }

    @Override
    public int delete(String code) {
        return 0;
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
