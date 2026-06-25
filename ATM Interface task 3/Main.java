/**
 * Main.java
 * This is the entry point of the ATM program.
 * It handles the user interface — showing the menu and reading input.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // --- Setup: Create a bank account with an initial balance ---
        System.out.println("===========================================");
        System.out.println("        WELCOME TO JAVA ATM SYSTEM         ");
        System.out.println("===========================================");

        // Step 1: Ask for account holder name
        System.out.print("Enter Account Holder name: ");
        String name = scanner.nextLine();

        // Step 2: Set a starting balance (you can change this)
        double startingBalance = 8000.0;

        // Step 3: Create the BankAccount object
        BankAccount myAccount = new BankAccount(name, startingBalance);

        // Step 4: Create the ATM object and link it to the account
        ATM atm = new ATM(myAccount);

        System.out.println("\nHello, " + name + "! Your account has been loaded.");
        System.out.printf("Starting Balance: Rs. %.2f%n", startingBalance);

        // --- Main Menu Loop ---
        boolean running = true;

        while (running) {
            // Display the menu
            System.out.println("\n==========================================");
            System.out.println("              ATM MAIN MENU                ");
            System.out.println("==========================================");
            System.out.println("  1. Check Balance");
            System.out.println("  2. Deposit Money");
            System.out.println("  3. Withdraw Money");
            System.out.println("  4. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice from (1-4): ");

            // Read the user's menu choice
            // We use a try-catch in case the user types something that isn't a number
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  INVALID INPUT: Please enter a number between 1 and 4.");
                continue; // Go back to the top of the loop
            }

            // Handle the user's choice
            switch (choice) {

                case 1:
                    // Check Balance
                    System.out.println("\n--- CHECKING BALANCE ---");
                    atm.checkBalance();
                    break;

                case 2:
                    // Deposit Money
                    System.out.println("\n--- DEPOSIT MONEY ---");
                    System.out.print("Enter amount to deposit (Rs.): ");
                    double depositAmount;
                    try {
                        depositAmount = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  INVALID INPUT: Please enter a valid amount.");
                        break;
                    }
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw Money
                    System.out.println("\n--- WITHDRAW MONEY ---");
                    System.out.print("Enter amount to withdraw (Rs.): ");
                    double withdrawAmount;
                    try {
                        withdrawAmount = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  INVALID INPUT: Please enter a valid amount.");
                        break;
                    }
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    // Exit
                    System.out.println("\n  Thank you for using Java ATM System!");
                    System.out.println("  Goodbye, " + name + "!");
                    System.out.println("==========================================");
                    running = false; // This exits the while loop
                    break;

                default:
                    // Any number other than 1-4
                    System.out.println("  INVALID CHOICE: Please select between 1 and 4.");
            }
        }

        // Close the scanner when done
        scanner.close();
    }
}
