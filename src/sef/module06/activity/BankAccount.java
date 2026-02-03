package sef.module06.activity;

public class BankAccount {

    // Encapsulation: private fields (no direct access outside)
    private final String accountNumber; // BONUS: immutable
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;

        // Ensure balance never starts negative
        this.balance = Math.max(0, initialBalance);
    }

    // Public getters (controlled read access)
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Public mutator with validation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be positive.");
            return;
        }
        applyBalanceChange(amount); // controlled update (inside class)
        System.out.println("Deposit successful: +" + amount);
    }

    // Public mutator with validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw failed: amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Withdraw failed: insufficient balance.");
            return;
        }
        applyBalanceChange(-amount); // controlled update (inside class)
        System.out.println("Withdraw successful: -" + amount);
    }

    // BONUS: protected method for subclass use (controlled access)
    protected void applyBalanceChange(double delta) {
        double newBalance = balance + delta;

        // Final safety: balance must never be negative
        if (newBalance < 0) {
            System.out.println("Operation blocked: balance cannot be negative.");
            return;
        }

        balance = newBalance;
    }
}
