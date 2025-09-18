package ui;

import service.AuthService;

import java.util.Scanner;

public class AuthMenu {
    private AuthService authService;
    private Scanner scanner = new Scanner(System.in);

    public AuthMenu(AuthService authService) {
        this.authService = authService;
    }

    public void showRegister() {
        System.out.println("=== Register ===");
        System.out.print("Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        String result = authService.register(name, email, password);
        System.out.println(result);
    }


    public void showLogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Mot de passe: ");
        String password = input.nextLine();

        boolean success = authService.login(email, password);
        if (success) {
            System.out.println("Connexion reussie !");
            HotelMenu hotelMenu = new HotelMenu();
            hotelMenu.showMenu();
        } else {
            System.out.println("Email ou mot de passe incorrect.");
        }
    }


}