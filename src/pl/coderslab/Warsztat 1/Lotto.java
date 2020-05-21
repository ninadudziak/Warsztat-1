import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Integer[] randomNumbers = lottoNumbers();
        System.out.println(Arrays.toString(randomNumbers));

        System.out.println("Write down numbers between 1-49." + "Remember, every number must be only once.");
        int[] guess = new int[6];
        int num = 0;

        while (num < 6) {
            int guessNumbers = userNumbers();
            if (checkIfNumber(userNumbers()) && !duplicate(guessNumbers, guess)) {
                guess[num] = guessNumbers;
                num++;
            } else {
                System.out.println("Please choose number between 1-49. Try again");
            }
        }
        Arrays.sort(guess);
        System.out.println(Arrays.toString(guess));

        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < randomNumbers.length; j++) {
                if (guess[i] == randomNumbers[j]) {
                    count++;
                }
            }
        }

        if (count == 6) {
            System.out.println("You guess all of them!");
        } else if (count == 5) {
            System.out.println("You guess 5 numbers. Close enough!");
        } else if (count == 4) {
            System.out.println("You guess 4 numbers. Nice try!");
        }else if (count == 3) {
            System.out.println("At least 3 numbers. Maybe next time will be better?");
        } else {
            System.out.println("Sorry but you didn't guess at least 3 numbers. Try again!");
        }
    }


    public static int userNumbers() {

        Scanner scan = new Scanner(System.in);


        while (!scan.hasNextInt()) {
            System.out.println("Please enter a number. Try again: ");
            scan.nextInt();
        }
        return scan.nextInt();
    }

    public static boolean checkIfNumber(int number) {
        boolean check = true;
        if (number < 1 || number > 49) {
            check = false;
        }
        return check;
    }

    public static boolean duplicate(int number, int[] arrOfNumbers) {
        for (int i = 0; i < arrOfNumbers.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (number == arrOfNumbers[i] && number == arrOfNumbers[j]) {
                        return true;
                }
            }
        }
        return false;
    }

    public static Integer[] lottoNumbers() {
    Integer[] lotto = new Integer[49] ;
    for (int i = 0; i < lotto.length; i++) {
        lotto[i] = i + 1;
    }
    Collections.shuffle(Arrays.asList(lotto));
    return Arrays.copyOf(lotto, 6);
    }
}