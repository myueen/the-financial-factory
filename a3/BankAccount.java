package a3;
public interface BankAccount {
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getInterestRate();
    double getAccountBalance();
}
