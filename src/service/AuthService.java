package service;

import domain.Client;
import repository.ClientRepository;

// Handles registration, login, and profile updates
public class AuthService {
    private ClientRepository clientRepo;

    public AuthService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    // Register a new client (returns message)
    public String register(String fullName, String email, String password) {
        if (email == null || email.isEmpty()) return "Email obligatoire.";
        if (password == null || password.length() < 6) return "Mot de passe trop court.";
        if (clientRepo.findByEmail(email) != null) return "Email deja utilise.";

        Client client = new Client(fullName, email, password);
        clientRepo.save(client);
        return "Inscription reussie.";
    }

    // Login (returns true if credentials are correct)
    public boolean login(String email, String password) {
        Client client = clientRepo.findByEmail(email);
        return client != null && client.getPassword().equals(password);
    }

    // Update email (returns message)
    public String updateEmail(Client client, String newEmail) {
        if (newEmail == null || newEmail.isEmpty()) return "Email obligatoire.";
        if (clientRepo.findByEmail(newEmail) != null) return "Email deja utilise.";
        client.setEmail(newEmail);
        clientRepo.save(client);
        return "Email mis a jour.";
    }

    // Change password (returns message)
    public String changePassword(Client client, String newPassword) {
        if (newPassword == null || newPassword.length() < 6) return "Mot de passe trop court.";
        client.setPassword(newPassword);
        clientRepo.save(client);
        return "Mot de passe mis a jour.";
    }
}