package sef.module06.activity;

public class Main {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("ACC-1001", 500);

        System.out.println("Account: " + acc.getAccountNumber());
        System.out.println("Balance: " + acc.getBalance());
        System.out.println("----");

        // Valid operations
        acc.deposit(200);
        acc.withdraw(100);

        // Invalid operations
        acc.deposit(-50);     // invalid deposit
        acc.withdraw(9999);   // exceeds balance
        acc.withdraw(-10);    // invalid withdraw

        System.out.println("----");
        System.out.println("Final Balance: " + acc.getBalance());
        System.out.println("================================");

        // Bonus: SavingsAccount + protected method usage
        SavingsAccount save = new SavingsAccount("SAV-2001", 1000, 5);

        System.out.println("Savings Account: " + save.getAccountNumber());
        System.out.println("Balance: " + save.getBalance());

        save.addMonthlyInterest();
        System.out.println("After Interest Balance: " + save.getBalance());
    }
}
