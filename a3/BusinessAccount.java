package a3;

import java.util.ArrayList;
import java.util.Scanner;

public class BusinessAccount implements BankAccount{
    public double interestRate = 0.0265;
    private String companyName;
    private int accountBalance;
    private double monthlyRevenue;


    public BusinessAccount(String company, int checkingBalance, double revenue){
        companyName = company;
        accountBalance = checkingBalance;
        monthlyRevenue = revenue;
    }


    public void getService() {
        System.out.println("==========================================================================");
        System.out.println("                                                                          ");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose one of the following options under Personal Account (a - g): " +
                "\n (a) Deposit Cash " +
                "\n (b) Withdraw Cash " +
                "\n (c) Operating Expense" +
                "\n (d) Emergency Funds" +
                "\n (e) Payrolls" +
                "\n (f) SavingsGoal" +
                "\n (g) Taxes");
        setService(sc1.nextLine());
    }


    public void setService(String service){
        Scanner sc1 = new Scanner(System.in);
        switch (service) {
            case "a":
                System.out.println("Amount to deposit: ");
                deposit(Double.parseDouble(sc1.nextLine()));
                break;
            case "b":
                System.out.println("Amount to withdraw: ");
                withdraw(Double.parseDouble(sc1.nextLine()));
                break;
            case "c":
                System.out.println();
                break;
            case "d":
                System.out.println("Your credit status is ");
                break;
            case "e":
                System.out.println("The interest rate is " + getInterestRate());
                break;
            case "f":
                System.out.println("Your account balance is " + getAccountBalance());
                break;
            case "g":
                System.out.println("How much loan are you planning to borrow? ");
//                getLoan(Double.parseDouble(sc1.nextLine()));
                break;
            default:
                System.out.println("Please choose only the available option!");
                System.out.println("Please choose one of the following options under Personal Account (a - g): " +
                        "\n (a) Deposit Cash " +
                        "\n (b) Withdraw Cash " +
                        "\n (c) Check Credit Score" +
                        "\n (d) Check Credit Status" +
                        "\n (e) Check Interest Rate" +
                        "\n (f) Account Balance");
                setService(sc1.nextLine());
        }
    }


     @Override
     public Boolean deposit(double amount){
         System.out.println("The amount to deposit is: " + amount);
         accountBalance += amount;
         System.out.println("Your account balance is: " + accountBalance);
         return true;
     };


     @Override
     public Boolean withdraw(double amount){
         System.out.println("The amount to withdraw is: " + amount);
         accountBalance -= amount;
         System.out.println("Your account balance is: " + accountBalance);
         return true;
     };


     @Override
     public double getInterestRate(){ return interestRate;};


     @Override
     public double getAccountBalance(){ return accountBalance;};

 }
