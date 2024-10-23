import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
    private static final int Min_Number = 1;
    private static final int Max_Number = 100;
    private static final int Max_Attempts = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("||---------------------NUMBER GUESSING GAME---------------------||");
        System.out.println("Total Number Of Attempts : 3");
        for (int i = 1; i <= Max_Attempts; i++) {
            int number = random.nextInt(Max_Number) + Min_Number;
            int attempts = 0;

            System.out.printf("Round:%d  Guess the number between %d and %d in %d attempts.\n", i, Min_Number , Max_Number,
                    Max_Attempts);
            while (attempts < Max_Attempts) {
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = Max_Attempts - attempts;
                    totalScore = totalScore + score;
                    System.out.printf("Hurray! Number Guessed Successfully. Attempts = %d.\n",
                            attempts, score);
                    break;
                } else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
                            Max_Attempts - attempts);
                } else if (guess_number > number) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
                            Max_Attempts - attempts);
                }

            }

            if (attempts == Max_Attempts) {
                System.out.printf("\nAttempts = %d\n", i);
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}