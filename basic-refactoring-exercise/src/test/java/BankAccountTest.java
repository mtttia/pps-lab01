import example.model.AccountHolder;
import example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {
    protected abstract BankAccount getBankAccount();
    protected abstract AccountHolder getAccountHolder();

    protected static final double EMPTY_AMOUNT = 0;
    protected static final double LARGE_POSITIVE_AMOUNT = 100;
    protected static final double SMALL_POSITIVE_AMOUNT = 70;
    protected static final double NEGATIVE_AMOUNT = -1;
    protected static final int RIGHT_USER_ID = 1;
    protected static final int WRONG_USER_ID = 2;

    protected void depositAndWithdraw(int depositAccountId, int withdrawAccountId, double depositAmount, double withdrawAmount) {
        getBankAccount().deposit(depositAccountId, depositAmount);
        getBankAccount().withdraw(withdrawAccountId, withdrawAmount);
    }

    protected void depositLargeAmountAndWithdrawSmallAmount(int depositAccountId, int withdrawAccountId) {
        depositAndWithdraw(depositAccountId, withdrawAccountId, LARGE_POSITIVE_AMOUNT, SMALL_POSITIVE_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(EMPTY_AMOUNT, getBankAccount().getBalance());
    }

    @Test
    void testDepositOnRightAccount() {
        getBankAccount().deposit(getAccountHolder().id(), LARGE_POSITIVE_AMOUNT);
        assertEquals(LARGE_POSITIVE_AMOUNT, getBankAccount().getBalance());
    }

    @Test
    void testDepositOnWrongUserId() {
        getBankAccount().deposit(getAccountHolder().id(), LARGE_POSITIVE_AMOUNT);
        getBankAccount().deposit(WRONG_USER_ID, SMALL_POSITIVE_AMOUNT);
        assertEquals(LARGE_POSITIVE_AMOUNT, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawWithAmountGreaterThanBalance() {
        depositAndWithdraw(getAccountHolder().id(), getAccountHolder().id(), SMALL_POSITIVE_AMOUNT, LARGE_POSITIVE_AMOUNT);
        assertEquals(SMALL_POSITIVE_AMOUNT, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawOnWrongUserId() {
        depositLargeAmountAndWithdrawSmallAmount(getAccountHolder().id(), WRONG_USER_ID);
        assertEquals(LARGE_POSITIVE_AMOUNT, getBankAccount().getBalance());
    }

    @Test
    void testWithdrawNegativeAmount(){
        depositAndWithdraw(getAccountHolder().id(), getAccountHolder().id(), LARGE_POSITIVE_AMOUNT, NEGATIVE_AMOUNT);
        assertEquals(LARGE_POSITIVE_AMOUNT, getBankAccount().getBalance());
    }
}
