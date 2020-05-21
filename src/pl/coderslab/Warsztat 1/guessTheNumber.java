import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {

        Random rand = new Random();
        int numberToGuess = rand.nextInt(100);
        Scanner scan = new Scanner(System.in);
        int guess = 0;

            System.out.println("Guess a number between 1 - 100: ");
            try{
                Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Number is incorrect. Try again:");
            }
            do {
                guess = scan.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Correct. Good work! Right number is: " + numberToGuess);
            } else if (guess < numberToGuess) {
                System.out.println("Too small");
            } else if (guess > numberToGuess) {
                System.out.println("Too big");
            }
        }
        while (guess != numberToGuess);
        }
    }