import java.util.*;

public class task2 {
    public static void main(String[] args) {
        GuessingGame();
    }

    static void GuessingGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int k = 0;
        System.out.println("A number is chosen between 1 to 100.");
        int guess = 0;
        while (guess != number) {
            System.out.println("Guess the number: ");
            guess = sc.nextInt();
            if (guess < number) {
                System.out.println("Wrong Guess! The number is greater than " + guess);
            } else if (guess > number) {
                System.out.println("Wrong guess! The number is less than " + guess);
            }
            k++;
        }
        System.out.println("CONGRATULATIONS! You guessed it correctly in " + k + " attempts.");

    }
}
