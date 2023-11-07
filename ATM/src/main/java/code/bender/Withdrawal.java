package code.bender;

import java.util.Scanner;
import java.util.logging.Logger;
/**
 * The Withdrawal class handles the process of withdrawing money from a bank account.
 */
public class Withdrawal {
    /**
     * Initializes a new Withdrawal instance with the specified bank account.
     *
     * @param bankAccount The bank account from which withdrawals will be made.
     */
    private static final Logger logger = Logger.getLogger( Withdrawal.class.getName() );
    private BankAccount bankAccount;
    public Withdrawal(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Perform a withdrawal operation.
     */
    public void withdraw() {
        Scanner scan = new Scanner(System.in);
        logger.info("Enter the amount you want to withdraw: ");
        int amount;
        int balance = bankAccount.getBalance();

        try {
            logger.info("Enter the amount you want to withdraw: ");
            amount = scan.nextInt();

            if (amount <= 0) {
                logger.warning("Invalid amount. Please enter a positive number.");
                return;
            }

            if (amount > balance) {
                logger.info("Insufficient funds. Your current balance is: R" + balance);
            } else {
                balance -= amount;
                bankAccount.setBalance(balance);
                logger.info("You have successfully withdrawn R" + amount + " . Your new balance is: R" + balance);
            }
        } catch (java.util.InputMismatchException e) {
            logger.warning("Invalid input. Please enter a valid number.");
        }
    }
}
