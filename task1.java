import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain;
        int totalScore = 0;
        int roundsPlayed = 0;
        
        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempt = 0;
            boolean hasGuessedCorrectly = false;
            final int maxAttempts = 10;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have a maximum of " + maxAttempts + " attempts.");
            
            while (attempt < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempt++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                    totalScore += maxAttempts - attempt + 1; // Score based on remaining attempts
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
            }

            roundsPlayed++;
            System.out.println("Your score after this round: " + totalScore);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
            
        } while (playAgain);

        System.out.println("Game Over! You played " + roundsPlayed + " rounds with a total score of " + totalScore);
        sc.close();
    }
}