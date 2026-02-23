import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private static final int EMPTY_AMOUNT = 0;
    private static final int LARGE_POSITIVE_AMOUNT = 100;
    private static final int SMALL_POSITIVE_AMOUNT = 70;
    private static final int RIGHT_USER_ID = 1;
    private static final int WRONG_USER_ID = 2;

    private void depositAndWithdraw(int depositAccountId, int withdrawAccountId, int depositAmount, int withdrawAmount) {
        bankAccount.deposit(depositAccountId, depositAmount);
        bankAccount.withdraw(withdrawAccountId, withdrawAmount);
    }

    private void depositLargeAmountAndWithdrawSmallAmount(int depositAccountId, int withdrawAccountId) {
        depositAndWithdraw(depositAccountId, withdrawAccountId, LARGE_POSITIVE_AMOUNT, SMALL_POSITIVE_AMOUNT);
    }

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", RIGHT_USER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, EMPTY_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(EMPTY_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), LARGE_POSITIVE_AMOUNT);
        assertEquals(LARGE_POSITIVE_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDepositOnWrongUserId() {
        bankAccount.deposit(accountHolder.id(), LARGE_POSITIVE_AMOUNT);
        bankAccount.deposit(WRONG_USER_ID, SMALL_POSITIVE_AMOUNT);
        assertEquals(LARGE_POSITIVE_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        depositLargeAmountAndWithdrawSmallAmount(accountHolder.id(), accountHolder.id());
        int remainAmount = LARGE_POSITIVE_AMOUNT - SMALL_POSITIVE_AMOUNT;
        assertEquals(remainAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAmountGreaterThanBalance() {
        depositAndWithdraw(accountHolder.id(), accountHolder.id(), SMALL_POSITIVE_AMOUNT, LARGE_POSITIVE_AMOUNT);
        assertEquals(SMALL_POSITIVE_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawOnWrongUserId() {
        depositLargeAmountAndWithdrawSmallAmount(accountHolder.id(), WRONG_USER_ID);
        assertEquals(LARGE_POSITIVE_AMOUNT, bankAccount.getBalance());
    }
}
