import java.util.ArrayList;
import java.util.Scanner;

abstract class Expense {
    private String description;
    private double amount;
    private String category;

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

    public abstract void displayDetails();
}

class TravelExpense extends Expense {
    private String destination;

    public TravelExpense(String description, double amount, String category, String destination) {
        super(description, amount, category);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public void displayDetails() {
        System.out.println("Travel Expense - Description: " + getDescription() +
                " | Amount: Rs." + getAmount() +
                " | Category: " + getCategory() +
                " | Destination: " + destination);
    }
}

class FoodExpense extends Expense {
    private String restaurant;

    public FoodExpense(String description, double amount, String category, String restaurant) {
        super(description, amount, category);
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }

    @Override
    public void displayDetails() {
        System.out.println("Food Expense - Description: " + getDescription() +
                " | Amount: Rs." + getAmount() +
                " | Category: " + getCategory() +
                " | Restaurant: " + restaurant);
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
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        return choice;
    }

    public static void addExpense(Scanner scanner) {
        System.out.println("Select expense type:");
        System.out.println("1. General Expense");
        System.out.println("2. Travel Expense");
        System.out.println("3. Food Expense");
        int type = getUserChoice(scanner);

        System.out.print("Enter the expense description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the expense amount: ");
        double amount;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); // Clear the buffer
                break;
            } else {
                System.out.print("Invalid input. Please enter a valid amount: ");
                scanner.next();
            }
        }

        System.out.print("Enter the expense category: ");
        String category = scanner.nextLine();

        switch (type) {
            case 1:
                expenses.add(new Expense(description, amount, category) {
                    @Override
                    public void displayDetails() {
                        System.out.println("General Expense - Description: " + getDescription() +
                                " | Amount: Rs." + getAmount() +
                                " | Category: " + getCategory());
                    }
                });
                break;
            case 2:
                System.out.print("Enter the destination: ");
                String destination = scanner.nextLine();
                expenses.add(new TravelExpense(description, amount, category, destination));
                break;
            case 3:
                System.out.print("Enter the restaurant name: ");
                String restaurant = scanner.nextLine();
                expenses.add(new FoodExpense(description, amount, category, restaurant));
                break;
            default:
                System.out.println("Invalid type. Adding as general expense.");
                expenses.add(new Expense(description, amount, category) {
                    @Override
                    public void displayDetails() {
                        System.out.println("General Expense - Description: " + getDescription() +
                                " | Amount: Rs." + getAmount() +
                                " | Category: " + getCategory());
                    }
                });
                break;
        }

        System.out.println("Expense added successfully.");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expenses:");
            for (Expense expense : expenses) {
                expense.displayDetails();
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
        System.out.println("2. Total expenses for a given time period (not implemented)");
        System.out.print("Enter your choice: ");

        int summaryChoice = getUserChoice(scanner);

        switch (summaryChoice) {
            case 1:
                System.out.print("Enter the category to summarize: ");
                String category = scanner.nextLine();
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
