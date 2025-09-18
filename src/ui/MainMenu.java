package ui;

// Main menu for unauthenticated users
public class MainMenu {
    public void showMenu() {
        System.out.println("=== Bienvenue a l'application de reservation d'hotels ===");
        System.out.println("1. Inscription");
        System.out.println("2. Connexion");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }
}