import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BankAccountTest{

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void initializeAccountHolderAndBankAccount() {
        accountHolder = new AccountHolder("Mario", "Rossi", RIGHT_USER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, EMPTY_AMOUNT);
    }

    @Override
    protected BankAccount getBankAccount() {
        return bankAccount;
    }

    @Override
    protected AccountHolder getAccountHolder() {
        return accountHolder;
    }

    @Test
    void testWithdrawWithCorrectAmount() {
        depositLargeAmountAndWithdrawSmallAmount(getAccountHolder().id(), getAccountHolder().id());
        double remainAmount = LARGE_POSITIVE_AMOUNT - SMALL_POSITIVE_AMOUNT;
        assertEquals(remainAmount, getBankAccount().getBalance());
    }
}
