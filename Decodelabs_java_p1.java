import java.util.Scanner;
import java.util.Random;

public class Decodelabs_java_p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("========== WELCOME TO THE NUMBER GAME ========== ");
        System.out.println("Brought to you by DecodeLabs Intern Track\n");

        while (playAgain) {
            totalRounds++;
        
            int numberToGuess = random.nextInt(100) + 1; 
            int attemptsLeft = 7; 
            boolean wonRound = false;

            System.out.println("--- Round " + totalRounds + " ---");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it. Good luck!\n");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); 
                    continue;
                }

                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed the correct number!");
                    
                    int pointsEarned = (attemptsLeft + 1) * 10; 
                    totalScore += pointsEarned;
                    System.out.println("Points earned this round: " + pointsEarned);
                    wonRound = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too High! Attempts remaining: " + attemptsLeft);
                } else {
                    System.out.println("Too Low! Attempts remaining: " + attemptsLeft);
                }
                System.out.println();
            }

            if (!wonRound) {
                System.out.println(" Game Over for this round! You've run out of attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

          
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            System.out.println();
        }

        // Display Final Game Summary
        System.out.println("================================================");
        System.out.println(" FINAL SCOREBOARD");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score Accumulated: " + totalScore + " pts");
        System.out.println("Thank you for playing! Keep up the great work With Arman.");
        System.out.println("================================================");

        scanner.close();
    }
}