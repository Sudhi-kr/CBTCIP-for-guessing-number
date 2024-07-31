import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Constants for the game
        final int MAX_ATTEMPTS = 10; // Maximum attempts per round
        final int POINTS_PER_ROUND = 100; // Points for guessing correctly

        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Variable to track total score
        int totalScore = 0;
        boolean playAgain = true;
// Game loop
        while (playAgain) {
            // Generate a random number between 1 and 100
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            int guess = 0;
            int attempts = 0;
            boolean correct = false;

            // Round loop
            while (attempts < MAX_ATTEMPTS && !correct) {
                System.out.print("Guess the number (1-100): ");
                
                // Check if input is an integer
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    attempts++;

                    // Check if the guess is too high, too low, or correct
                    if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > randomNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You've guessed the number!");
                        int points = POINTS_PER_ROUND - (attempts - 1) * 10; // Calculate points
                        totalScore += points > 0 ? points : 0; // Add points to total score
                        System.out.println("You earned " + points + " points this round.");
                        correct = true;
                    }
                } else {
                    // Handle non-integer input
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            // End of round message
            if (!correct) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your total score is: " + totalScore);
            // Prompt to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        // End of game message
        System.out.println("Thanks for playing! Your final score is: " + totalScore);

        // Close the scanner
        scanner.close();
    }
}

