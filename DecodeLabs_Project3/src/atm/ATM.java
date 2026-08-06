package atm;

import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {

        this.account = account;
        scanner = new Scanner(System.in);

    }

    // Start ATM
    public void start() {

        System.out.println("\n========== ATM LOGIN ==========");

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter 4-Digit PIN: ");

            while (!scanner.hasNextInt()) {

                System.out.println("Invalid Input! Enter Numbers Only.");
                scanner.next();

            }

            int enteredPin = scanner.nextInt();

            if (account.verifyPin(enteredPin)) {

                System.out.println("\nLogin Successful.");
                menu();
                return;

            } else {

                attempts--;

                System.out.println("Incorrect PIN.");

                if (attempts > 0)
                    System.out.println("Attempts Left: " + attempts);

            }

        }

        System.out.println("ATM Blocked. Too Many Incorrect Attempts.");

    }

    // ATM Menu
    private void menu() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("           ATM MENU");
            System.out.println("=================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            while (!scanner.hasNextInt()) {

                System.out.println("Invalid Input!");
                scanner.next();

            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    deposit();

                    break;

                case 2:

                    withdraw();

                    break;

                case 3:

                    account.checkBalance();

                    break;

                case 4:

                    account.showTransactionHistory();

                    break;

                case 5:

                    System.out.println("Thank You For Using Our ATM.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 5);

    }

    // Deposit Method
    private void deposit() {

        System.out.print("Enter Deposit Amount: ₹");

        while (!scanner.hasNextDouble()) {

            System.out.println("Invalid Amount.");
            scanner.next();

        }

        double amount = scanner.nextDouble();

        account.deposit(amount);

    }

    // Withdraw Method
    private void withdraw() {

        System.out.print("Enter Withdrawal Amount: ₹");

        while (!scanner.hasNextDouble()) {

            System.out.println("Invalid Amount.");
            scanner.next();

        }

        double amount = scanner.nextDouble();

        account.withdraw(amount);

    }

}