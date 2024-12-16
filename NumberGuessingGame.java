import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean playAgain = true;

            System.out.println("Welcome to the Number Guessing Game!");

            // Main game loop
            while (playAgain) {
                int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
                int attempts = 0;
                int maxAttempts = 10; // Maximum number of attempts allowed
                boolean guessedCorrectly = false;

                System.out.println("\nI've picked a number between 1 and 100. You have " + maxAttempts + " attempts to guess it!");

                // Loop for user guesses
                while (attempts < maxAttempts) {
                    System.out.print("Please enter your guess: ");
                    
                    // Input validation for integers
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.next(); // Clear the invalid input
                        continue; // Skip the rest of the loop and prompt for input again
                    }

                    int userGuess = scanner.nextInt();
                    attempts++;

                    // Check if the guess is correct
                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break; // Exit the guessing loop
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Your guess is too low! Try again.");
                    } else {
                        System.out.println("Your guess is too high! Try again.");
                    }
                }

                // If the user didn't guess correctly within the allowed attempts
                if (!guessedCorrectly) {
                    System.out.println("Sorry! You've used all your attempts. The correct number was: " + numberToGuess);
                }

                // Ask if the user wants to play again
                System.out.print("\nDo you want to play again? (yes/no): ");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");
            }

            System.out.println("Thank you for playing! Goodbye.");
        }
    }
}
