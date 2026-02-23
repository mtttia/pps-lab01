import example.model.AccountHolder;
import example.model.BankAccountWithWithdrawFee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountWithWithdrawFeeTest extends SimpleBankAccountTest{

    @Override
    @BeforeEach
    void initializeAccountHolderAndBankAccount(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", RIGHT_USER_ID);
        this.bankAccount = new BankAccountWithWithdrawFee(accountHolder, EMPTY_AMOUNT);
    }

    @Test
    @Override
    void testWithdrawWithCorrectAmount() {
        depositLargeAmountAndWithdrawSmallAmount(accountHolder.id(), accountHolder.id());
        int remainAmount = LARGE_POSITIVE_AMOUNT - SMALL_POSITIVE_AMOUNT - 1;
        assertEquals(remainAmount, bankAccount.getBalance());
    }
}
