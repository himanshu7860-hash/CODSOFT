/**
 * BankAccount.java
 * This class represents a user's bank account.
 * It stores the balance and provides methods to get/set it.
 */
public class BankAccount {

    // The account holder's name
    private String accountHolderName;

    // The current balance in the account
    private double balance;

    // Constructor: called when we create a new BankAccount object
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Returns the current balance
    public double getBalance() {
        return balance;
    }

    // Returns the account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Adds money to the account (used for deposits)
    public void deposit(double amount) {
        balance += amount;
    }

    // Removes money from the account (used for withdrawals)
    public void withdraw(double amount) {
        balance -= amount;
    }
}
