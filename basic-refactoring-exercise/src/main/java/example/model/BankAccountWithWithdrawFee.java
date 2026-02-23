package example.model;

public class BankAccountWithWithdrawFee implements BankAccount{

    public static final double WITHDRAW_FEE = 1;
    private final BankAccount baseBankAccount;

    public BankAccountWithWithdrawFee(AccountHolder holder, double balance) {
        baseBankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public double getBalance() {
        return baseBankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        baseBankAccount.deposit(userID, amount);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        baseBankAccount.withdraw(userID, getWithdrawAmountWithFee(amount));
    }

    private double getWithdrawAmountWithFee(final double amount){
        return amount + WITHDRAW_FEE;
    }
}
