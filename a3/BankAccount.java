package a3;
public interface BankAccount {
    Boolean deposit(double amount);
    Boolean withdraw(double amount);
    double getInterestRate();
    double getAccountBalance();

}
