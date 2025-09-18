import domain.Client;
import repository.*;
import service.*;
import ui.MainMenu;
import ui.UserMenu;
import utils.ConsoleUtils;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories and services
        ClientRepository clientRepo = new InMemoryClientRepository();
        HotelRepository hotelRepo = new InMemoryHotelRepository();
        ReservationRepository reservationRepo = new InMemoryReservationRepository();

        AuthService authService = new AuthService(clientRepo);
        HotelService hotelService = new HotelService(hotelRepo, reservationRepo);
        ReservationService reservationService = new ReservationService(reservationRepo, hotelRepo);

        MainMenu mainMenu = new MainMenu();
        UserMenu userMenu = new UserMenu();

        Client currentUser = null; // Tracks the logged-in user

        while (true) {
            if (currentUser == null) {
                // Show main menu for unauthenticated users
                mainMenu.showMenu();
                int choice = ConsoleUtils.readInt("", 0);

                if (choice == 1) {
                    // Registration
                    String name = ConsoleUtils.readNonEmptyString("Nom complet : ");
                    String email = ConsoleUtils.readNonEmptyString("Email : ");
                    String password = ConsoleUtils.readNonEmptyString("Mot de passe (min 6 caractères) : ");
                    String result = authService.register(name, email, password);
                    System.out.println(result);
                } else if (choice == 2) {
                    // Login
                    String email = ConsoleUtils.readNonEmptyString("Email : ");
                    String password = ConsoleUtils.readNonEmptyString("Mot de passe : ");
                    boolean success = authService.login(email, password);
                    if (success) {
                        currentUser = clientRepo.findByEmail(email);
                        System.out.println("Connexion réussie !");
                    } else {
                        System.out.println("Email ou mot de passe incorrect.");
                    }
                } else if (choice == 0) {
                    System.out.println("Au revoir !");
                    break;
                } else {
                    System.out.println("Option invalide.");
                }
            } else {
                // Show menu for authenticated users
                userMenu.showMenu(currentUser.getFullName());
                int choice = ConsoleUtils.readInt("", 0);

                if (choice == 1) {
                    // Create hotel (admin)
                    String hotelId = ConsoleUtils.readNonEmptyString("ID hôtel : ");
                    String name = ConsoleUtils.readNonEmptyString("Nom hôtel : ");
                    String address = ConsoleUtils.readNonEmptyString("Adresse : ");
                    int rooms = ConsoleUtils.readInt("Nombre de chambres : ", 1);
                    double rating = ConsoleUtils.readDouble("Note : ", 0);
                    String result = hotelService.createHotel(hotelId, name, address, rooms, rating);
                    System.out.println(result);
                } else if (choice == 2) {
                    // List hotels
                    for (domain.Hotel h : hotelService.listHotels()) {
                        System.out.println(h);
                    }
                } else if (choice == 3) {
                    // Reserve room
                    String hotelId = ConsoleUtils.readNonEmptyString("ID hôtel à réserver : ");
                    int nights = ConsoleUtils.readInt("Nombre de nuits : ", 1);
                    String result = reservationService.reserveRoom(hotelId, currentUser.getId(), nights);
                    System.out.println(result);
                } else if (choice == 4) {
                    // Cancel reservation
                    String resIdStr = ConsoleUtils.readNonEmptyString("ID réservation à annuler : ");
                    try {
                        UUID resId = UUID.fromString(resIdStr);
                        String result = reservationService.cancelReservation(resId, currentUser.getId());
                        System.out.println(result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("ID réservation invalide.");
                    }
                } else if (choice == 5) {
                    // Reservation history
                    for (domain.Reservation r : reservationService.getHistory(currentUser.getId())) {
                        System.out.println(r);
                    }
                } else if (choice == 6) {
                    // Update profile (email)
                    String newEmail = ConsoleUtils.readNonEmptyString("Nouvel email : ");
                    String result = authService.updateEmail(currentUser, newEmail);
                    System.out.println(result);
                } else if (choice == 7) {
                    // Change password
                    String newPassword = ConsoleUtils.readNonEmptyString("Nouveau mot de passe : ");
                    String result = authService.changePassword(currentUser, newPassword);
                    System.out.println(result);
                } else if (choice == 8) {
                    // Logout
                    currentUser = null;
                    System.out.println("Déconnecté.");
                } else if (choice == 0) {
                    System.out.println("Au revoir !");
                    break;
                } else {
                    System.out.println("Option invalide.");
                }
            }
        }
    }
}