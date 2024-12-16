import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            double usdToInr = 82.5;
            double usdToEur = 0.92;
            double eurToInr = 89.5;
            double eurToUsd = 1.09;

            System.out.println("Welcome to the Currency Converter!");

            // Step 1: Get base currency choice
            int baseCurrency = getCurrencyChoice(scanner, "Select the base currency:\n1. USD\n2. EUR\n3. INR");

            // Step 2: Get target currency choice
            int targetCurrency = getCurrencyChoice(scanner, "Select the target currency:\n1. USD\n2. EUR\n3. INR");

            // Step 3: Get the amount to convert
            double amount = getAmount(scanner);

            // Step 4: Convert the amount
            double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount, usdToEur, usdToInr, eurToUsd, eurToInr);

            // Step 5: Display the result
            displayResult(convertedAmount, targetCurrency);
        }
    }

    private static int getCurrencyChoice(Scanner scanner, String message) {
        System.out.println(message);
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid selection! Please choose 1, 2, or 3.");
                }
            } else {
                System.out.println("That's not a valid number. Please try again.");
                scanner.next();  // Clear the invalid input
            }
        }
    }

    private static double getAmount(Scanner scanner) {
        System.out.print("Enter the amount to convert: ");
        double amount;
        while (true) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    return amount;
                } else {
                    System.out.println("Amount cannot be negative. Please enter a valid amount.");
                }
            } else {
                System.out.println("That's not a valid number. Please try again.");
                scanner.next();  // Clear the invalid input
            }
        }
    }

    private static double convertCurrency(int baseCurrency, int targetCurrency, double amount, double usdToEur, double usdToInr, double eurToUsd, double eurToInr) {
        if (baseCurrency == 1 && targetCurrency == 2) {
            return amount * usdToEur;
        } else if (baseCurrency == 1 && targetCurrency == 3) {
            return amount * usdToInr;
        } else if (baseCurrency == 2 && targetCurrency == 1) {
            return amount * eurToUsd;
        } else if (baseCurrency == 2 && targetCurrency == 3) {
            return amount * eurToInr;
        } else if (baseCurrency == 3 && targetCurrency == 1) {
            return amount / usdToInr;
        } else if (baseCurrency == 3 && targetCurrency == 2) {
            return amount / eurToInr;
        } else if (baseCurrency == targetCurrency) {
            return amount; // No conversion needed
        } else {
            System.out.println("Invalid selection! Please try again.");
            return 0;
        }
    }

    private static void displayResult(double convertedAmount, int targetCurrency) {
        String[] currencies = {"USD", "EUR", "INR"};
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, currencies[targetCurrency - 1]);
    }
}
