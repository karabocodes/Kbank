package code.bender;

import static code.bender.Menu.bankAccount;

public class Balance {
    public static void checkBalance() {
        System.out.println("");
        System.out.println("You have R" + bankAccount.getBalance() + " in your account.");
    }
}
