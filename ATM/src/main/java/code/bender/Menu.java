package code.bender;

import java.util.Scanner;
import java.util.logging.Logger;

import static code.bender.Balance.checkBalance;


public class Menu {
    private static Scanner scan = new Scanner(System.in);
    public static BankAccount bankAccount = new BankAccount();
    private static Withdrawal withdrawal = new Withdrawal(bankAccount);
    private static Deposit deposit = new Deposit(bankAccount);
    private static Quit quit = new Quit();
    private static final Logger logger = Logger.getLogger( Withdrawal.class.getName() );


    public static void displayMenu() {
        boolean exit = false;

        while (!exit) {
            try {
                displayMenuOptions();

                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdrawal.withdraw();
                        break;
                    case 3:
                        deposit.depositAmount();
                        break;
                    case 4:
                        logger.info("Exiting, thank you for using the service.");
                        quit.exit();
                        exit = true; // Set exit to true to break out of the loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                logger.warning("Invalid input. Please enter a valid number.");
                scan.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
    }


    private static void displayMenuOptions() {
        System.out.println("\nMain Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }
}
