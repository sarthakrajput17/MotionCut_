import java.util.*;

public class Week2Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter!");
        System.out.println("Please choose an option:");
        System.out.println("1. Convert from Celsius to Fahrenheit");
        System.out.println("2. Convert from Fahrenheit to Celsius");

        int choice = sc.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            return;
        }

        System.out.print("Enter the temperature value: ");
        double temperature = sc.nextDouble();

        if (choice == 1) {
            double convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Result: " + convertedTemperature + " Fahrenheit");
        } else {
            double convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Result: " + convertedTemperature + " Celsius");
        }
    }

    // Converts Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Converts Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
