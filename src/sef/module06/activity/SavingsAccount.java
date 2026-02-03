package sef.module06.activity;

public class SavingsAccount extends BankAccount {

    private double interestRate; // extra field

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    // Subclass-specific behavior
    public void addMonthlyInterest() {
        if (interestRate <= 0) {
            System.out.println("Interest not added: invalid interest rate.");
            return;
        }

        double interest = getBalance() * (interestRate / 100.0);
        applyBalanceChange(interest); // uses protected method (bonus)
        System.out.println("Interest added: +" + interest);
    }
}
