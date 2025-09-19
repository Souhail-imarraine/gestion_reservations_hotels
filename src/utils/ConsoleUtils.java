package utils;

import java.util.Scanner;

// Utility class for console input and validation
public class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    // Read a non-empty string
    public static String readNonEmptyString(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
        } while (value.isEmpty());
        return value;
    }

    // Read an integer with minimum value
    public static int readInt(String prompt, int min) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min) return value;
            } catch (NumberFormatException e) {

            }
            System.out.println("Veuillez entrer un nombre >= " + min);
        }
    }

    // Read a double with minimum value
    public static double readDouble(String prompt, double min) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value >= min) return value;
            } catch (NumberFormatException e) {
            }
            System.out.println("Veuillez entrer un nombre >= " + min);
        }
    }
}