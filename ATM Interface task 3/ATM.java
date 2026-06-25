/**
 * ATM.java
 * This class represents the ATM machine.
 * It is connected to a BankAccount and handles all transactions.
 */
public class ATM {

    // The bank account linked to this ATM session
    private BankAccount account;

    // Maximum withdrawal limit per transaction
    private static final double MAX_WITHDRAWAL_LIMIT = 12000.0;

    // Minimum deposit amount
    private static final double MIN_DEPOSIT_AMOUNT = 1.0;

    // Constructor: links the ATM to a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    /**
     * Checks and displays the current balance.
     */
    public void checkBalance() {
        System.out.println("----------------------------------");
        System.out.println("  Account Holder Name : " + account.getAccountHolderName());
        System.out.printf("  Current Balance in Rs. : Rs. %.2f%n", account.getBalance());
        System.out.println("----------------------------------");
    }

    /**
     * Deposits a given amount into the account.
     * Validates that the amount is positive and meets the minimum.
     */
    public void deposit(double amount) {
        System.out.println("----------------------------------");

        // Validation: amount must be positive
        if (amount <= 0) {
            System.out.println("  ERROR: Deposit amount must be greater than zero.");
        }
        // Validation: must meet minimum deposit requirement
        else if (amount < MIN_DEPOSIT_AMOUNT) {
            System.out.println("  ERROR: Minimum deposit amount should be Rs. " + MIN_DEPOSIT_AMOUNT);
        }
        else {
            // All checks passed — perform the deposit
            account.deposit(amount);
            System.out.printf("  SUCCESS: Rs. %.2f deposited successfully!%n", amount);
            System.out.printf("  New Balance: Rs. %.2f%n", account.getBalance());
        }

        System.out.println("----------------------------------");
    }

    /**
     * Withdraws a given amount from the account.
     * Validates balance, limits, and amount validity.
     */
    public void withdraw(double amount) {
        System.out.println("----------------------------------");

        // Validation: amount must be positive
        if (amount <= 0) {
            System.out.println("  ERROR: Withdrawal amount must be greater than zero.");
        }
        // Validation: cannot exceed withdrawal limit
        else if (amount > MAX_WITHDRAWAL_LIMIT) {
            System.out.printf("  ERROR: Cannot withdraw more than Rs. %.2f at once.%n", MAX_WITHDRAWAL_LIMIT);
        }
        // Validation: must have sufficient balance
        else if (amount > account.getBalance()) {
            System.out.println("  ERROR: Insufficient balance!");
            System.out.printf("  Your current balance is: Rs. %.2f%n", account.getBalance());
        }
        else {
            // All checks passed — perform the withdrawal
            account.withdraw(amount);
            System.out.printf("  SUCCESS: Rs. %.2f withdrawn successfully!%n", amount);
            System.out.printf("  Remaining Balance: Rs. %.2f%n", account.getBalance());
        }

        System.out.println("-------------------------------------");
    }
}
