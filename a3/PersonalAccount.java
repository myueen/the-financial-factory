package a3;

import java.util.Scanner;

import static java.lang.Math.round;

public class PersonalAccount implements BankAccount{
     public static double minimumDailyBalance = 100;
     public double interestRate = 0.0265;
     private String firstName;
     private String lastName;
     private int accountNumber;
     private double accountBalance;
     private int creditScore;
     private String creditStatus;
     private double loanAmount;
     private double annualPercentRate;
     private double monthlyPayment;

     //Constructor
    public PersonalAccount(String firstN, String lastN, int accountNum, int creditS, double accountBal) {
        this.firstName = firstN;
        this.lastName = lastN;
        this.accountNumber = accountNum;
        this.creditScore = creditS;
        this.accountBalance = accountBal;
    }


    public void getService() {
        greeting();
        Boolean exit = false;
        while(!exit) {
            System.out.println("                                                                          ");
            System.out.println("                                                                          ");
            System.out.println("==========================================================================");
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Please choose one of the following options under Personal Account (a - g): " +
                    "\n (a) Deposit Cash " +
                    "\n (b) Withdraw Cash " +
                    "\n (c) Check Credit Score" +
                    "\n (d) Check Credit Status" +
                    "\n (e) Check Interest Rate" +
                    "\n (f) Account Balance" +
                    "\n (g) Get a loan");
            setService(sc1.nextLine());
            exit = moreService();
        }
        System.out.println("Thank you for being our preferred client! Have a good day.");
    }


     // Interface Method
    @Override
     public Boolean deposit(double amount){
        System.out.println("The amount to deposit is: " + amount);
        accountBalance += amount;
        System.out.println("Your account balance is: " + accountBalance);
        return true;
    }


     @Override
     public Boolean withdraw(double amount){
        if(accountBalance < minimumDailyBalance) {
            System.out.println("The account balance is below minimum daily balance.");
            return true;
        }

        System.out.println("The amount to withdraw is: " + amount);
        accountBalance -= amount;
        System.out.println("Your account balance is: " + accountBalance);
        return true;
     }

     @Override
     public double getInterestRate(){ return interestRate;}


     @Override
     public double getAccountBalance(){ return accountBalance;}


     // Additional Method
     private void greeting(){
         System.out.println("==========================================================================");
         System.out.println("                                                                          ");
         System.out.println("Dear " + firstName + " " + lastName + ", \n" +
                 "Welcome to your personal account under account number " + accountNumber + ". ");
     }


     private void setService(String service){
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
                 System.out.println("Your credit score is " + getCreditScore());
                 break;
             case "d":
                 System.out.println("Your credit status is " + getCreditStatus());
                 break;
             case "e":
                 System.out.println("The interest rate is " + getInterestRate());
                 break;
             case "f":
                 System.out.println("Your account balance is " + getAccountBalance());
                 break;
             case "g":
                 System.out.println("How much loan are you planning to borrow? ");
                 getLoan(Double.parseDouble(sc1.nextLine()));
                 break;
             default:
                 System.out.println("Please choose only the available option!");
                 System.out.println("Please choose one of the following options under Personal Account (a - f): " +
                         "\n (a) Deposit Cash " +
                         "\n (b) Withdraw Cash " +
                         "\n (c) Check Credit Score" +
                         "\n (d) Check Credit Status" +
                         "\n (e) Check Interest Rate" +
                         "\n (f) Account Balance");
                 setService(sc1.nextLine());
         }
     }


     private Boolean moreService(){
         System.out.println("Would you like to proceed to another option? Please enter Y or N. ");
         Scanner sc1 = new Scanner(System.in);
         String additionalService = sc1.next();

         while(!additionalService.equals("Y") && !additionalService.equals("N")) {
             System.out.println("Please only choose the available option.");
             System.out.println("Would you like to proceed to another option? Please enter Y or N. ");
             additionalService = sc1.next();
         }

         if(additionalService.equals("Y")) {
             return false;
         } else {
             return true;
         }
     }


     private int getCreditScore(){ return creditScore;}


     private String getCreditStatus(){
        if(creditScore >= 800){
            creditStatus = "Exceptional";
        } else if(creditScore >= 740 && creditScore <= 799){
            creditStatus = "Very good";
        } else if(creditScore >= 670 && creditScore <= 739) {
            creditStatus =  "Good";
        } else if(creditScore >= 580 && creditScore <= 669) {
            creditStatus =  "Fair";
        } else if(creditScore >= 300 && creditScore <= 579) {
            creditStatus =  "Poor";
        } else {
            creditStatus =  "Not available";
        }
        return creditStatus;
     }


     public Boolean getLoan(double loan){
        loanAmount = loan;
        switch(getCreditStatus()){
            case "Excellent":
            case "Very good":
                annualPercentRate = 0.05;
                break;
            case "Good":
                annualPercentRate = 0.10;
                break;
            case "Fair":
            case "Poor":
                annualPercentRate = 0.15;
                break;
            default:
                System.out.println("No credit status available");
                return true;
        }
        monthlyPayment = (annualPercentRate/12) * loanAmount;
        System.out.println("                                                                          ");
        System.out.println("==========================================================================");
        System.out.println("Your monthly payment for a loan amount of " + loanAmount + " is " + round(monthlyPayment) + ". ");
        return true;
     }








}
