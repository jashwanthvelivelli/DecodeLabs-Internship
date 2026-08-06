package atm;

public class Main {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("        WELCOME TO JAVA ATM");
        System.out.println("=======================================");

        // Create Bank Account
        BankAccount account = new BankAccount(
                "Jashwanth",
                "1234567890",
                1234,
                10000
        );

        // Create ATM Object
        ATM atm = new ATM(account);

        // Start ATM
        atm.start();

        System.out.println("\n=======================================");
        System.out.println("Thank You For Using Our ATM.");
        System.out.println("=======================================");

    }
}