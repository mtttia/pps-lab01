package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    private static final int INITIAL_AMOUNT = 0;
    private static final int INITIAL_DEPOSIT = 100;
    private static final int ALLOWED_WITHDRAW_AMOUNT = 30;
    private static final int NOT_ALLOWED_WITHDRAW_AMOUNT = 80;

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, INITIAL_AMOUNT);
        bankAccount.deposit(accountHolder.id(), INITIAL_DEPOSIT);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.id(), ALLOWED_WITHDRAW_AMOUNT);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.id(), NOT_ALLOWED_WITHDRAW_AMOUNT);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
