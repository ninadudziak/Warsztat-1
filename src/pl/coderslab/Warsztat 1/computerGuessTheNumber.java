import java.util.Scanner;

public class computerGuessTheNumber {
    public static void main(String[] args) {

        System.out.println("Think the number between 1-1000. Got it? Now, let me guess it in max. 10 moves!. Tap anything to start");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        int min = 1;
        int max = 1000;

        int numberOfGuessing = 10;

        while (numberOfGuessing > 0) {

            int guess = ((max - min)/2) + min;
            System.out.println("I'm guessing it's " + guess);
            numberOfGuessing--;

            Scanner scan = new Scanner(System.in);
            System.out.println("Tell me: \"too big\", \"too small\", \"guessed\"");
            String input = scan.nextLine();

            if (input.equals("guessed")) {
                System.out.println("I guessed at " + (10 - numberOfGuessing) + " attempt");
                break;
            } else if (input.equals("too big")) {
                max = guess;
            } else if (input.equals("too small")) {
                min = guess;
            } else {
                System.out.println("Don't cheat!");
            }
        }
    }
}
