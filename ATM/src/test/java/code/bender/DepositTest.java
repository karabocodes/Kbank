package code.bender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class DepositTest {
    private Deposit deposit;
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        // Initialize the BankAccount and Deposit objects
        bankAccount = new BankAccount();
        deposit = new Deposit(bankAccount);
    }

    @Test
    public void testDepositAmount() {
        bankAccount.setBalance(0);

        System.setIn(new ByteArrayInputStream("100\n".getBytes()));

        deposit.depositAmount();

        assertEquals(100 , bankAccount.getBalance());
    }
}