import repository.InMemoryClientRepository;
import service.AuthService;
import java.util.Scanner;
import ui.AuthMenu;
import ui.MainMenu;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MainMenu main = new MainMenu();
        InMemoryClientRepository clientRepo = new InMemoryClientRepository();
        AuthService authService = new AuthService(clientRepo);
        AuthMenu authMenu = new AuthMenu(authService);

        while (true) {
            main.showMenu();
            int choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1) {
                authMenu.showRegister();
            } else if (choice == 2) {
                authMenu.showLogin();
            } else if (choice == 0) {
                System.exit(0);
            } else {
                System.out.println("Option invalide.");
            }
        }
    }
}