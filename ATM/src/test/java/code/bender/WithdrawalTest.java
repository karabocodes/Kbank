package code.bender;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WithdrawalTest {
    private Withdrawal withdrawal;
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        // Initialize the BankAccount and Withdrawal objects
        bankAccount = new BankAccount();
        withdrawal = new Withdrawal(bankAccount);
    }

    @Test
    public void testWithdrawalWithSufficientFunds() {
        // Set the initial balance to 1000
        bankAccount.setBalance(1000);

        // Provide input for the scanner (simulate user input)
        System.setIn(new ByteArrayInputStream("500\n".getBytes()));

        // Perform the withdrawal
        withdrawal.withdraw();

        // Check if the balance was updated correctly
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    public void testWithInsufficientFunds(){
        bankAccount.setBalance(1000);
        System.setIn(new ByteArrayInputStream("1500\n".getBytes()));

        withdrawal.withdraw();

        assertEquals(1000, bankAccount.getBalance());
    }

}
