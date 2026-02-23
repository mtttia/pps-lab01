package example.model;

public class BankAccountWithWithdrawFee extends SimpleBankAccount{
    public BankAccountWithWithdrawFee(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (isBankAccountHolder(userID) && isWithdrawAllowed(amount)) {
            this.balance -= getWithdrawAmountWithFee(amount);
        }
    }

    protected boolean isWithdrawAllowed(final double amount){
        return amount >= MINIMUM_WITHDRAW_AMOUNT && this.balance >= getWithdrawAmountWithFee(amount);
    }

    private double getWithdrawAmountWithFee(final double amount){
        return amount + 1;
    }
}
