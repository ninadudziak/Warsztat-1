import java.util.Random;

public class Dice {

    //kostka do gry

    public static void main(String[] args) {
        int wynik = rollDice("D10+20");
        System.out.println(wynik);

        int wynik2 = rollDice("5D10+20");
        System.out.println(wynik2);

    }

    public static int rollDice(String dice) {
        int d = dice.indexOf("D");
        String xStr = dice.substring(0, d);
        int x = 0;
        if (xStr.equals("")) {
            x = 1;
        } else {
            x = Integer.parseInt(xStr);
        }

        int y, z;
        if (dice.contains("+")) {
            int plus = dice.indexOf("+");
            String yStr = dice.substring(d + 1, plus);
            y = Integer.parseInt(yStr);
        } else if (
                dice.contains("-")) {
            int minus = dice.indexOf("-");
            String yStr = dice.substring(d + 1, minus);
            y = Integer.parseInt(yStr);

            String zStr = dice.substring(minus);
            z = Integer.parseInt(zStr);
        } else {
            String yStr = dice.substring(d + 1);
            y = Integer.parseInt(yStr);
            z = 0;
        }
        int result = generateNumber(x, y, x);
        return result;

    } public static int generateNumber(int x, int y, int z) {
        Random random = new Random();
        int result = 0;
        for (int i = 0; i < x; i++) {
            result += random.nextInt(y) + 1;
        }
        result += z;

        return result;
        }
    }
