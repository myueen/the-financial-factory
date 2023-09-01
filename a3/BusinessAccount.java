package a3;

import java.util.Scanner;

import static java.lang.Math.round;

public class BusinessAccount implements BankAccount{
    public double interestRate = 0.0265;
    private String companyName;
    private int accountNumber;
    private double accountBalance;
    private double monthlyRevenue;
    private float operatingExpense;
    private float emergencyFunds;
    private float payRoll;
    private int employees = 0;
    private float employeeIncome = 0;
    private float savingsGoal;
    private float taxes;


    public BusinessAccount(String company, int accountNum, double checkingBalance, double revenue){
        companyName = company;
        accountNumber = accountNum;
        accountBalance = checkingBalance;
        monthlyRevenue = revenue;
    }


    public void getService() {
        System.out.println("==========================================================================");
        greeting();
        System.out.println("                                                                          ");
        Scanner sc1 = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("                                                                          ");
            System.out.println("==========================================================================");
            System.out.println("Please choose one of the following options under Personal Account (a - g): " +
                    "\n (a) Deposit Cash " +
                    "\n (b) Withdraw Cash " +
                    "\n (c) Operating Expense" +
                    "\n (d) Emergency Funds" +
                    "\n (e) Payrolls" +
                    "\n (f) SavingsGoal" +
                    "\n (g) Taxes");
            setService(sc1.nextLine());
            exit = moreService();
        }
        System.out.println("Thank you for using our business account to manage expenses and savings!");
    }


     @Override
     public boolean deposit(double amount){
         System.out.println("The amount to deposit is: " + amount);
         accountBalance += amount;
         System.out.println("The account balance is: " + accountBalance);
         return true;
     }


     @Override
     public boolean withdraw(double amount){
         System.out.println("The amount to withdraw is: " + amount);
         accountBalance -= amount;
         System.out.println("The account balance is: " + accountBalance);
         return true;
     }


     @Override
     public double getInterestRate(){ return interestRate;}


     @Override
     public double getAccountBalance(){ return accountBalance;}


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
                operatingExpense();
                break;
            case "d":
                emergencyFunds();
                break;
            case "e":
                payRolls();
                break;
            case "f":
                SavingsGoal();
                break;
            case "g":
                Taxes();
                break;
            default:
                System.out.println("Please choose only the available option!");
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
    }


    private boolean moreService(){
        System.out.println("Would you like to proceed to another option? Please enter Y or N. ");
        Scanner sc1 = new Scanner(System.in);
        String additionalService = sc1.next();

        while(!additionalService.equals("Y") && !additionalService.equals("N")) {
            System.out.println("Please only choose the available option.");
            System.out.println("Would you like to proceed to another option? Please enter Y or N. ");
            additionalService = sc1.next();
        }

        if(additionalService.equals("Y")) { return false;}
        return true;
    }


    private void operatingExpense(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose the following option (a/b):\n " +
                "(a) Set up operating expense." + " (b) Pay for operating expense.");
        String option = sc1.nextLine();
        if(!option.equals("a") && !option.equals("b")){
            System.out.println("Please choose only the options provided.");
            System.out.println("Please choose the following option (a/b): \n " +
                    "(a) Set up operating expense. " +
                    "(b) Pay for operating expense. ");
            option = sc1.nextLine();
        }

        if(option.equals("a")){
            System.out.println("What percentage of revenue for operating expense? Please enter the percentage here: ");
            float percentage = Float.parseFloat(sc1.nextLine());
            setOperatingExpense(percentage);
        } else {
            System.out.println("What is the amount needed to pay for operating expense? Please enter the amount here: ");
            float amount = Float.parseFloat(sc1.nextLine());
            payOperatingExpense(amount);
        }
    }


    private void setOperatingExpense(float percent){
        operatingExpense = round(monthlyRevenue * percent);
        monthlyRevenue -= operatingExpense;
        if(monthlyRevenue <= 0 ){
            System.out.println("There is not enough monthly revenue left for this percentage. Please enter a smaller percentage: ");
            Scanner sc1 = new Scanner(System.in);
            setOperatingExpense(Float.parseFloat(sc1.nextLine()));
        }
        System.out.println("Your current operating expense checking account is " + operatingExpense);
        System.out.println("Your monthlyRevenue remains " + monthlyRevenue);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void payOperatingExpense(float amount){
        System.out.println("Operating expense:" + operatingExpense);
        System.out.println("Amount to withdraw: " + amount);

        while (amount >= operatingExpense){
            System.out.println("There is not enough money in the operating expense checking account. Please enter a greater percentage of monthly revenue: ");
            Scanner sc1 = new Scanner(System.in);
            setOperatingExpense(Float.parseFloat(sc1.nextLine()));
        }

        operatingExpense -= amount;
        System.out.println("Your current operating expense checking accounts balance is " + operatingExpense);
    }


    private void emergencyFunds(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose the following option (a/b): \n " +
                "(a) Set up emergency funds." + " (b) Release emergency funds. ");
        String option = sc1.nextLine();
        if(!option.equals("a") && !option.equals("b")){
            System.out.println("Please choose only the options provided.");
            System.out.println("Please choose the following option (a/b): \n " +
                    "(a) Set up emergency funds. " +
                    "(b) Release emergency funds. ");
            option = sc1.nextLine();
        }

        if(option.equals("a")){
            System.out.println("What percentage of revenue for emergency funds monthly? Please enter the percentage here: ");
            float percentage = Float.parseFloat(sc1.nextLine());
            setEmergencyFunds(percentage);
        } else {
            releaseEmergencyFunds();
        }
    }


    private void setEmergencyFunds(float percent){
        emergencyFunds = round(monthlyRevenue * percent);
        monthlyRevenue -= emergencyFunds;
        if(monthlyRevenue <= 0 ){
            System.out.println("There is not enough monthly revenue left for this percentage. Please enter a smaller percentage: ");
            Scanner sc1 = new Scanner(System.in);
            setEmergencyFunds(Float.parseFloat(sc1.nextLine()));
        }

        System.out.println("Your current emergency funds checking account balance is " + emergencyFunds);
        System.out.println("Your monthlyRevenue remains " + monthlyRevenue);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void releaseEmergencyFunds(){
        accountBalance += emergencyFunds;
        emergencyFunds -= emergencyFunds;
        System.out.println("Your current amount of emergency fund is " + emergencyFunds);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void payRolls(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose the following option (a/b): \n " +
                "(a) Set up monthly payrolls" + " (b) Pay employees ");
        String option = sc1.nextLine();
        if(!option.equals("a") && !option.equals("b")){
            System.out.println("Please choose only the options provided.");
            System.out.println("Please choose the following option (a/b): \n " +
                    "(a) Set up monthly payrolls " +
                    "(b) Pay employees ");
            option = sc1.nextLine();

        }

        if(option.equals("a")){
            System.out.println("What percentage of revenue for payrolls monthly? Please enter the percentage here: ");
            float percent = Float.parseFloat(sc1.nextLine());
            setPayroll(percent);
        } else {
            System.out.println("How many employees in your business? Please enter here: ");
            int numOfEmployees = Integer.parseInt(sc1.nextLine());
            System.out.println("What amount to pay for each employee? Please enter here: ");
            float payAmount = Float.parseFloat(sc1.nextLine());
            payEmployees(numOfEmployees, payAmount);
        }

    }


    private void setPayroll(float percent){
        payRoll = round(monthlyRevenue * percent);
        monthlyRevenue -= payRoll;
        if(monthlyRevenue <= 0 ){
            System.out.println("There is not enough monthly revenue left for this percentage. Please enter a smaller percentage: ");
            Scanner sc1 = new Scanner(System.in);
            setPayroll(Float.parseFloat(sc1.nextLine()));
        }

        System.out.println("Your current amount of payroll checking account balance is " + payRoll);
        System.out.println("Your monthlyRevenue remains " + monthlyRevenue);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void payEmployees(int num, float amount){
        employees = num;
        employeeIncome = amount;
        float total = employees * employeeIncome;

        while(total >= payRoll){
            System.out.println("There is not enough money in the payroll checking account. Please enter a greater percentage of monthly revenue: ");
            Scanner sc1 = new Scanner(System.in);
            setPayroll(Float.parseFloat(sc1.nextLine()));
        }

        System.out.println("Payroll checking account balance: " + payRoll);
        System.out.println("Amount to withdraw: " + total);
        payRoll -= total;
        System.out.println("Your current payroll checking account balance is " + payRoll);
    }


    private void SavingsGoal(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose the following option (a/b): \n " +
                "(a) Set up saving goals" + " (b) Take out money from saving goals account.");
        String option = sc1.nextLine();
        if(!option.equals("a") && !option.equals("b")){
            System.out.println("Please choose only the options provided.");
            System.out.println("Please choose the following option (a/b): \n " +
                    "(a) Set up saving goals" + " (b) Take out money from saving goals account.");
            option = sc1.nextLine();

        }

        if(option.equals("a")){
            System.out.println("What percentage of revenue for savings goal monthly? Please enter the percentage here: ");
            float percent = Float.parseFloat(sc1.nextLine());
            setSavingsGoal(percent);
        } else {
            System.out.println("What is the amount needed to pay for savingsGoal? Please enter the amount here: ");
            float amount = Float.parseFloat(sc1.nextLine());
            paySavingsGoal(amount);
        }
    }


    private void setSavingsGoal(float percent){
        float amount = round(monthlyRevenue * percent);
        monthlyRevenue -= savingsGoal;
        savingsGoal += amount;
        if(monthlyRevenue <= 0 ){
            System.out.println("There is not enough monthly revenue left for this percentage. Please enter a smaller percentage: ");
            Scanner sc1 = new Scanner(System.in);
            setSavingsGoal(Float.parseFloat(sc1.nextLine()));
        }

        System.out.println("The amount to put into savings is "+ amount);
        System.out.println("Your savingsGoal checking account balance is " + savingsGoal);
        System.out.println("Your monthlyRevenue remains " + monthlyRevenue);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void paySavingsGoal(float amount) {
        System.out.println("The amount of payment is " + amount);
        while(amount >= taxes){
            System.out.println("There is not enough money in the taxes checking account. Please enter a greater percentage of monthly revenue: ");
            Scanner sc1 = new Scanner(System.in);
            setTaxes(Float.parseFloat(sc1.nextLine()));
        }
        savingsGoal -= amount;
        System.out.println("Your savingsGoal checking account balance is " + savingsGoal);
    }



    private void Taxes(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose the following option (a/b): \n " +
                "(a) Set up taxes. " + "(b) Pay taxes. ");
        String option = sc1.nextLine();
        if(!option.equals("a") && !option.equals("b")){
            System.out.println("Please choose only the options provided.");
            System.out.println("Please choose the following option (a/b): \n " +
                    "(a) Set up taxes. " +
                    "(b) Pay taxes. ");
            option = sc1.nextLine();
        }

        if(option.equals("a")){
            System.out.println("What percentage of revenue for taxes? Please enter the percentage here: ");
            float percentage = Float.parseFloat(sc1.nextLine());
            setTaxes(percentage);
        } else {
            System.out.println("What is the amount needed to pay for taxes? Please enter the amount here: ");
            float amount = Float.parseFloat(sc1.nextLine());
            payTaxes(amount);
        }
    }


    private void setTaxes(float percentage){
        taxes = round(monthlyRevenue * percentage);
        monthlyRevenue -= taxes;
        if(monthlyRevenue <= 0 ){
            System.out.println("There is not enough monthly revenue left for this percentage. Please enter a smaller percentage: ");
            Scanner sc1 = new Scanner(System.in);
            setPayroll(Float.parseFloat(sc1.nextLine()));
        }

        System.out.println("Your current amount of taxes checking account balance is " + taxes);
        System.out.println("Your monthlyRevenue remains " + monthlyRevenue);
        System.out.println("Your total account balance is " + (monthlyRevenue + accountBalance));
    }


    private void payTaxes(float amount){
        System.out.println("The amount of taxes is " + amount);
        while(amount >= taxes){
            System.out.println("There is not enough money in the taxes checking account. Please enter a greater percentage of monthly revenue: ");
            Scanner sc1 = new Scanner(System.in);
            setTaxes(Float.parseFloat(sc1.nextLine()));
        }
        taxes -= amount;
        System.out.println("Your taxes checking account balance is " + taxes);
    }


    private void greeting(){
        System.out.println("==========================================================================");
        System.out.println("                                                                          ");
        System.out.println("Hello " + companyName + ", \n" +
                "Welcome to your business account under account number " + accountNumber + ". ");
    }

}
