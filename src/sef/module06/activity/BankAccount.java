package sef.module06.activity;

public class BankAccount {

    private final String accountNumber; // immutable
    private double balance;

    private static final int PIN = 445566; // fixed PIN
    private boolean authenticated = false;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(0, initialBalance);
    }

    // PIN authentication
    public boolean authenticate(int enteredPin) {
        if (enteredPin == PIN) {
            authenticated = true;
            System.out.println("PIN correct. Access granted.");
            return true;
        } else {
            System.out.println("Wrong PIN. Access denied.");
            return false;
        }
    }

    // Getters (allowed only after PIN verification)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (!authenticated) {
            System.out.println("Access denied. Please enter correct PIN.");
            return -1;
        }
        return balance;
    }

    public void deposit(double amount) {
        if (!authenticated) {
            System.out.println("Deposit blocked. Please authenticate first.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be positive.");
            return;
        }

        applyBalanceChange(amount);
        System.out.println("Deposit successful: +" + amount);
    }

    public void withdraw(double amount) {
        if (!authenticated) {
            System.out.println("Withdrawal blocked. Please authenticate first.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Withdraw failed: amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Withdraw failed: insufficient balance.");
            return;
        }

        applyBalanceChange(-amount);
        System.out.println("Withdraw successful: -" + amount);
    }

    // protected method for subclass (bonus)
    protected void applyBalanceChange(double delta) {
        double newBalance = balance + delta;
        if (newBalance >= 0) {
            balance = newBalance;
        }
    }
}
