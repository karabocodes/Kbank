package code.bender;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The Deposit class handles the process of depositing money into a bank account.
 */
public class Deposit {

    private static final Logger logger = Logger.getLogger(Deposit.class.getName());
    private BankAccount bankAccount;

    /**
     * Initializes a new Deposit instance with the specified bank account.
     *
     * @param bankAccount The bank account where the deposit will be made.
     */
    public Deposit(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Perform a deposit operation.
     */
    public void depositAmount() {
        Scanner scan = new Scanner(System.in);

        logger.info("Enter the amount you want to deposit: ");

        try {
            int amount = Integer.parseInt(scan.nextLine());

            if (amount <= 0) {
                logger.warning("Invalid amount. Please enter a positive number.");
                return;
            }

            int balance = bankAccount.getBalance();
            balance += amount;
            bankAccount.setBalance(balance);
            logger.info("You have successfully deposited R" + amount + ". Your new balance is: R" + balance);
        } catch (NumberFormatException e) {
            logger.warning("Invalid input. Please enter a valid number.");
        }
    }
}
