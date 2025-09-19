package repository;

import domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// In-memory implementation of ClientRepository
public class InMemoryClientRepository implements ClientRepository {
    private List<Client> clients = new ArrayList<>();

    @Override
    public void save(Client client) {
        // If client exists (by email), update; else, add new
        Client existing = findByEmail(client.getEmail());
        if (existing != null) {
            clients.remove(existing);
        }
        clients.add(client);
    }

    @Override
    public Client findByEmail(String email) {
        for (Client c : clients) {
            if (c.getEmail().equalsIgnoreCase(email)) return c;
        }
        return null;
    }

    @Override
    public Client findById(UUID id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }
}