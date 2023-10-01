import java.util.*;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st Number");
        int a = sc.nextInt();
        System.out.println("Enter 2nd Number");
        int b = sc.nextInt();

        System.out.println("Operations available are:- ");
        System.out.println("1: Addition_ a+b");
        System.out.println("2: Subtraction_ a-b");
        System.out.println("3: Multiplication_ a*b");
        System.out.println("4: Division_ a/b");
        System.out.println("Enter your choice: ");

        int operation = sc.nextInt();
        System.out.println("Answer is: ");

        switch (operation) {
            case 1:
                System.out.println(a + b);
                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                System.out.println(a * b);
                break;
            case 4:
                System.out.println(a / b);
                break;
            case 5:
                System.out.println("Invalid Choice");
                break;
        }
    }
}
