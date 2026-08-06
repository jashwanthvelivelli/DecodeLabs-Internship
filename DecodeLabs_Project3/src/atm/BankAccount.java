package atm;

import java.util.ArrayList;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int pin;
    private double balance;

    private ArrayList<String> transactionHistory;

    public BankAccount(String accountHolderName,
                       String accountNumber,
                       int pin,
                       double balance) {

        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;

        transactionHistory = new ArrayList<>();

        transactionHistory.add("Account Created with Balance: ₹" + balance);
    }

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;
            transactionHistory.add("Deposited ₹" + amount);

            System.out.println("₹" + amount + " Deposited Successfully.");

        } else {

            System.out.println("Invalid Deposit Amount.");

        }

    }

    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid Withdrawal Amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient Balance.");

        } else {

            balance -= amount;
            transactionHistory.add("Withdrawn ₹" + amount);

            System.out.println("Please Collect Your Cash.");

        }

    }

    public void checkBalance() {

        System.out.println("Current Balance : ₹" + balance);

    }

    public void showTransactionHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (String transaction : transactionHistory) {

            System.out.println(transaction);

        }

    }

    public String getAccountHolderName() {

        return accountHolderName;

    }

    public String getAccountNumber() {

        return accountNumber;

    }

}