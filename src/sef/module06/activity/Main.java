package sef.module06.activity;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount("ACC-1001", 500);

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        // Authenticate first
        if (!account.authenticate(pin)) {
            System.out.println("Program terminated.");
            return;
        }

        // Menu-driven actions
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(scanner.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(scanner.nextDouble());
                    break;

                case 3:
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
