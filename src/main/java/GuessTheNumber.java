import java.util.Scanner;
import java.util.Random;

class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int guess = -1;
        int number = random.nextInt(10);

        do {
            while (count < 3 && guess != number) {
                System.out.print("Guess the number (0..9): ");
                guess = sc.nextInt();

                if (number != guess) {
                    System.out.println("Your number is " +
                            ((guess > number) ? "greater" : "less"));
                    count++;
                }
            } System.out.println("You " +
                    ((guess == number) ? "WIN!" : "Lose: " + number));

            System.out.println("Repeat game? Yes - 1, No - 0");
        } while (sc.nextInt() == 1);
    }
}

