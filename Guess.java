
import java.util.Random;
import javax.swing.JOptionPane;

public class Guess {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        int round = 1;

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        boolean guessedCorrectly = false;
        while (!guessedCorrectly && maxAttempts > 0) {
            String guessString = JOptionPane.showInputDialog("Round " + round + ": Guess the number between " + minRange + " and " + maxRange);
            
            // Validate user input
            int guess;
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                continue;
            }

            if (guess == randomNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
                score += maxAttempts;
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }

            maxAttempts--;
            round++;
        }

        JOptionPane.showMessageDialog(null, "Game over! The number was " + randomNumber + ".\nYour score is: " + score);
    }
}
