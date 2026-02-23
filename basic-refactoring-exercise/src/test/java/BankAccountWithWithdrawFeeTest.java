import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.BankAccountWithWithdrawFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountWithWithdrawFeeTest extends BankAccountTest{

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void initializeAccountHolderAndBankAccount(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", RIGHT_USER_ID);
        this.bankAccount = new BankAccountWithWithdrawFee(accountHolder, EMPTY_AMOUNT);
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
        depositLargeAmountAndWithdrawSmallAmount(accountHolder.id(), accountHolder.id());
        double remainAmount = LARGE_POSITIVE_AMOUNT - SMALL_POSITIVE_AMOUNT - BankAccountWithWithdrawFee.WITHDRAW_FEE;
        assertEquals(remainAmount, bankAccount.getBalance());
    }
}
