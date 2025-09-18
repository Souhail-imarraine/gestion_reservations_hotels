package ui;

// Menu for authenticated users
public class UserMenu {
    public void showMenu(String userName) {
        System.out.println("\n=== Connecte en tant que " + userName + " ===");
        System.out.println("1. Creer un hotel (admin)");
        System.out.println("2. Liste des hotels");
        System.out.println("3. Reserver une chambre");
        System.out.println("4. Annuler une reservation");
        System.out.println("5. Historique des reservations");
        System.out.println("6. Modifier le profil");
        System.out.println("7. Changer le mot de passe");
        System.out.println("8. Deconnexion");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }
}