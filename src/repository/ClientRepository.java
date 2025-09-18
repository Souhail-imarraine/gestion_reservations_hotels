package repository;

import domain.Client;
import java.util.UUID;
import java.util.List;

// Interface for client data access
public interface ClientRepository {
	void save(Client client); // Add or update a client
	Client findByEmail(String email); // Find client by email
	Client findById(UUID id); // Find client by ID
	List<Client> findAll(); // List all clients
}