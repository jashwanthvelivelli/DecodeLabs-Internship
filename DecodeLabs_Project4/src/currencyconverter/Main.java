package currencyconverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char choice;

        System.out.println("=========================================");
        System.out.println("     DECODELABS CURRENCY CONVERTER");
        System.out.println("=========================================");

        do {

            CurrencyConverter converter = new CurrencyConverter();

            converter.start();

            System.out.print("\nDo you want to convert another currency? (Y/N): ");

            choice = scanner.next().toUpperCase().charAt(0);

        } while (choice == 'Y');

        System.out.println("\n=========================================");
        System.out.println("Thank You for Using Currency Converter!");
        System.out.println("=========================================");

        scanner.close();
    }
}