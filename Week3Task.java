import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    public String description;
    public double amount;
    public String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class Week3Task {
    public static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(sc);

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    showExpenseSummaries(sc);
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Expense Tracker Menu:");
        System.out.println("1. Add an expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Expense Summaries");
        System.out.println("4. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid choice. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void addExpense(Scanner scanner) {
        System.out.print("Enter the expense description: ");
        String description = scanner.next();

        System.out.print("Enter the expense amount: ");
        double amount;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid amount: ");
                scanner.next();
            }
        }

        System.out.print("Enter the expense category: ");
        String category = scanner.next();

        expenses.add(new Expense(description, amount, category));
        System.out.println("Expense added successfully.");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                Expense expense = expenses.get(i);
                System.out.println((i + 1) + ". Description: " + expense.getDescription() +
                        " | Amount: Rs." + expense.getAmount() +
                        " | Category: " + expense.getCategory());
            }
        }
    }

    public static void showExpenseSummaries(Scanner scanner) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }

        System.out.println("Expense Summaries:");
        System.out.println("1. Total expenses for a specific category");
        System.out.println("2. Total expenses for a given time period");
        System.out.print("Enter your choice: ");

        int summaryChoice = getUserChoice(scanner);

        switch (summaryChoice) {
            case 1:
                System.out.print("Enter the category to summarize: ");
                String category = scanner.next();
                double totalCategoryExpense = calculateTotalCategoryExpense(category);
                System.out.println("Total expenses for category '" + category + "': Rs." + totalCategoryExpense);
                break;
            case 2:

                System.out.println("Time-based summaries are not implemented in this version.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static double calculateTotalCategoryExpense(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }
        return total;
    }
}
