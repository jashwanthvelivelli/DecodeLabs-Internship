package currencyconverter;

import java.util.Scanner;

public class CurrencyConverter {

    private ExchangeRate exchangeRate;
    private Scanner scanner;

    // Constructor
    public CurrencyConverter() {

        exchangeRate = new ExchangeRate();
        scanner = new Scanner(System.in);

    }

    // Start Currency Converter
    public void start() {

        System.out.println("\n========== CURRENCY CONVERTER ==========");

        exchangeRate.displayCurrencies();

        String fromCurrency;
        String toCurrency;

        // Source Currency
        while (true) {

            System.out.print("\nEnter Source Currency: ");
            fromCurrency = scanner.next().toUpperCase();

            if (exchangeRate.isValidCurrency(fromCurrency))
                break;

            System.out.println("Invalid Currency!");

        }

        // Target Currency
        while (true) {

            System.out.print("Enter Target Currency: ");
            toCurrency = scanner.next().toUpperCase();

            if (exchangeRate.isValidCurrency(toCurrency))
                break;

            System.out.println("Invalid Currency!");

        }

        // Amount
        double amount;

        while (true) {

            try {

                System.out.print("Enter Amount: ");
                amount = scanner.nextDouble();

                if (amount > 0)
                    break;

                System.out.println("Amount must be greater than zero.");

            } catch (Exception e) {

                System.out.println("Invalid Input! Please enter numbers only.");
                scanner.next();

            }

        }

        convertCurrency(fromCurrency, toCurrency, amount);

    }

    // Conversion Method
    private void convertCurrency(String from,
                                 String to,
                                 double amount) {

        double fromRate = exchangeRate.getRate(from);
        double toRate = exchangeRate.getRate(to);

        double convertedAmount = (amount / fromRate) * toRate;

        System.out.println("\n=========================================");
        System.out.println("        CONVERSION RESULT");
        System.out.println("=========================================");
        System.out.printf("%.2f %s = %.2f %s%n",
                amount,
                from,
                convertedAmount,
                to);
        System.out.println("=========================================");

    }

}