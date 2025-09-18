package service;

import domain.Client;
import repository.InMemoryClientRepository;

public class AuthService {
    private InMemoryClientRepository clientRepo;
    //    constructor
    public AuthService(InMemoryClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public String register(String fullName, String email, String password) {
        if(fullName.trim().isEmpty() || fullName.length() < 6){
            return "full Name is required.";
        }

        if (email == null || email.trim().isEmpty()) {
            return "Email is required.";
        }

        if (password == null || password.length() < 6) {
            return "Password must be at least 6 characters.";
        }

        if (clientRepo.findByEmail(email) != null) {
            return "Email already registered.";
        }

        Client client = new Client(fullName, email, password);
        clientRepo.save(client);
        return "Registration successful!";
    }

     public boolean login(String email, String password) {
        return clientRepo.findByEmailAndPassword(email, password) != null;
    }
}