package repository;

import domain.Client;
import java.util.ArrayList;
import java.util.List;

public class InMemoryClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void save(Client client) {
        clients.add(client);
    }

    public Client findByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

     public Client findByEmailAndPassword(String email, String password) {
        for (Client client : clients) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }
}