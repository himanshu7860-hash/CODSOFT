import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

    static int generateSecretNumber(int minBound, int maxBound) {
        Random rand = new Random();
        return rand.nextInt((maxBound - minBound) + 1) + minBound;
    }

    static String evaluateGuess(int userGuess, int secretNumber) {
        if (userGuess == secretNumber) {
            return "CORRECT";
        } else if (userGuess > secretNumber) {
            return "TOO_HIGH";
        } else {
            return "TOO_LOW";
        }
    }

    static void displayFeedback(String result, int attemptCount) {
        switch (result) {
            case "TOO_HIGH":
                System.out.println(">> Your guess is too HIGH. Try a smaller number!");
                break;
            case "TOO_LOW":
                System.out.println(">> Your guess is too LOW. Try a larger number!");
                break;
            case "CORRECT":
                System.out.println("\n*** Congratulations! You have guessed it right in " + attemptCount + " attempt(s)! ***");
                break;
        }
    }

    static int readValidGuess(Scanner scanner, int min, int max) {
        int guess = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your guess (" + min + " - " + max + "): ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                if (guess >= min && guess <= max) {
                    validInput = true;
                } else {
                    System.out.println("!! Out of range. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("!! Invalid input. Please enter a valid integer.");
                scanner.next(); // discard bad input
            }
        }
        return guess;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int LOWER = 1;
        final int UPPER = 100;
        boolean playAgain = true;

        System.out.println("==============================");
        System.out.println("  WELCOME TO GUESS THE NUMBER ");
        System.out.println("==============================\n");

        while (playAgain) {
            int secretNumber = generateSecretNumber(LOWER, UPPER);
            int attemptCount = 0;
            boolean hasWon = false;

            System.out.println("I have picked a number between " + LOWER + " and " + UPPER + ". Can you guess it?\n");

            while (!hasWon) {
                int userGuess = readValidGuess(scanner, LOWER, UPPER);
                attemptCount++;

                String result = evaluateGuess(userGuess, secretNumber);
                displayFeedback(result, attemptCount);

                if (result.equals("CORRECT")) {
                    hasWon = true;
                }
            }

            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            System.out.println();
        }

        System.out.println("Thanks for playing! Have a good day.");
        scanner.close();
    }
}
