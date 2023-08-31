package a3;

import java.util.*;

public class AccountManagement {
    public String service;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String physicalAddress;
    private String emailAddress;
    private int AccountNumber;
    private double accountBalance;

    public AccountManagement(String business) {
        this.service = business;
    }


    public void getService() {
        System.out.println("==========================================================================");
        System.out.println("                                                                          ");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please choose one of the following options under Account Management (a - b): ");
        System.out.println("(a) Open a checking account");
        System.out.println("(b) Open a saving account");
        setService(sc1.nextLine());
    }


    private void setService(String service) {
         switch(service) {
            case "a":
                openAccount("a");
                break;
            case "b":
                openAccount("b");
                break;
            default:
                System.out.println("Please enter only the options provided!");
                while(!service.equals("a") && !service.equals("b") && !service.equals("c")){
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Please choose one of the following options under Account Management (a - c): ");
                    System.out.println( "(a) Open a checking account " );
                    System.out.println( "(b) Open a saving account" );
                    System.out.println( "(c) Update account info" );
                    service = sc2.nextLine();
                    setService(service);
                }
        }
    }


    private void openAccount(String accountType) {
        System.out.println("                                                                          ");
        System.out.println("==========================================================================");
        System.out.println("                                                                          ");
        System.out.println("Welcome to the a3.Bank! Please enter the following information:");
        System.out.println("                                                                          ");

        Scanner sc1 = new Scanner(System.in);
        System.out.println("First name: ");
        firstName = sc1.nextLine();

        System.out.println("Last name: ");
        lastName = sc1.nextLine();

        System.out.println("Date of Birth (MM/DD/YY): ");
        dateOfBirth = sc1.nextLine();

        System.out.println("Physical Address: ");
        physicalAddress = sc1.nextLine();

        System.out.println("Email Address: ");
        emailAddress = sc1.nextLine();

        confirmInfo();
        System.out.println("                                                                          ");
        makeChanges();
        System.out.println("What is your initial deposit? Please enter the amount: ");
        accountBalance = Double.parseDouble(sc1.nextLine());
        System.out.println("                                                                          ");

        endMessage(accountType);
    }


    private void makeChanges(){
        String change = "Y";
        Scanner sc1 = new Scanner(System.in);
        while(change.equals("Y")){
            System.out.println("Are there changes to make? Please enter Y or N");
            change = sc1.nextLine();
            while(!change.equals("Y") && !change.equals("N")) {
                System.out.println("Please enter Y or N: ");
                change = sc1.nextLine();
            }

            if(change.equals("Y")){
                System.out.println("Please choose one of the following options (a-e): ");
                System.out.println("(a) First Name");
                System.out.println("(b) Last Name ");
                System.out.println("(c) Date of Birth");
                System.out.println("(d) Physical Address");
                System.out.println("(e) Email Address");
                String changeVariable = sc1.nextLine();
                updateInfo(changeVariable);
                confirmInfo();
            } else {
                System.out.println("==========================================================================");
                System.out.println("                                                                          ");
            }
        }
    }


    private void endMessage(String accountType){
        System.out.println("Dear "+ firstName + " " + lastName + ", \n");
        if(accountType.equals("a")) {
            String checkingAccount = "checking account";
            System.out.println("Your " + checkingAccount + "number is " + accountNumberGenerator() + ". \n" +
                    "The account balance is " + accountBalance + ". \n" +
                    "The physical card will be mailed within the next 3-7 business day. \n" +
                    "Meanwhile, if you have any question, please contact our Account Manager Miss.Ma \n" +
                    "by dialing 781-308-2462 or by email liana.yema@gmail.com. Thank you!" );
        } else {
            AccountNumber = accountNumberGenerator();
            System.out.println("Your saving account number number is " + AccountNumber + ". \n" +
                    "The physical card will be mailed within the next 3-7 business day. \n" +
                    "Meanwhile, if you have any questions, please contact our Account Manager Miss.Ma \n" +
                    "by dialing 781-308-2462 or by emailing liana.yema@gmail.com. Thank you!" );
        }
    }


    private static int accountNumberGenerator(){
        Random num = new Random();
        int high = 1000000000;
        int low = 10000000;
        return num.nextInt(high-low);
    }


    private void confirmInfo() {
        System.out.println("==========================================================================");
        System.out.println("                                                                          ");
        System.out.println("                                                                          ");
        System.out.println("Please confirm the following information: ");
        System.out.println("Applicant names:  " + firstName + " " + lastName);
        System.out.println("Date of Birth:    " + dateOfBirth);
        System.out.println("Physical Address: " + physicalAddress);
        System.out.println("Email Address:    " + emailAddress);
    }


    private void updateInfo(String variable){
        Scanner sc1 = new Scanner(System.in);
        switch (variable) {
            case "a":
                System.out.println("First name change to: ");
                firstName = sc1.nextLine();
                break;
            case "b":
                System.out.println("Last name change to: ");
                lastName = sc1.nextLine();
                break;
            case "c":
                System.out.println("Date of Birth change to: ");
                dateOfBirth = sc1.nextLine();
                break;
            case "d":
                System.out.println("Physical address change to: ");
                physicalAddress = sc1.nextLine();
                break;
            case "e":
                System.out.println("Email address change to: ");
                emailAddress = sc1.nextLine();
                break;
            default:
                System.out.println("Please choose only the options provided! ");
                System.out.println("                                                                          ");

                while(!variable.equals("a") && !variable.equals("b") && !variable.equals("c") && !variable.equals("d") && !variable.equals("e")){
                    System.out.println("Please choose one of the following options (a-e): ");
                    System.out.println("(a) First Name");
                    System.out.println("(b) Last Name");
                    System.out.println("(c) Date of Birth");
                    System.out.println("(d) Physical Address");
                    System.out.println("(e) Email Address");
                    variable = sc1.nextLine();
                    updateInfo(variable);
                }
        }
    }
}