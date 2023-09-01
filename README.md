# BankManagement_Project

### Plan of Design:
This project creates a program using Java that mimics the functioning of a bank. Rather than simpling depositing and withdrawing money as an ATM, this program have the following additional benefits. First, the bank account opening is simulated by a subprogram named "Account Management". An interface "BankAccount" is used that includes the method signatures. Both "Personal Account" and "Business Account" implements the "BankAccount" interface and each meets different needs for different audience. In addition to depositing and withdrawing money, the personal account program offers users more options such as checking credit status and getting a loan. The business account offers an ever more diverse choices at managing the checking amount of a business. It allows account owner to allocate money for different purposes such as operating expenses, taxes, payrolls, and emergency funds. The business account program allows business owners to effectively subdivide the monthly revenue into different categories for management and payments.       

(1) OpenAccount
(2) Business bank account: (pay suppliers and employees, make purchases for your business, make business tax payments)
(3) Personal bank account: (deposit paycheck, pay household bills, make personal purchase. )
(4) BankAccount interface


## Account Management
Description: This programs stimulate the process of opening a new bank account online. A survey-format question is provided to gather information for the new account. After the user confirmed the information they enter, user can put in their initial deposit. 
1. __getService()__: The open page that prompts the user to type in the service they want. 
2. __setService(String service)__: Allows the program to categorize the user's input and run the subsequent program.
3. __openAccount(String accountType)__: A method that prompts a series of questions that gathers information for the new bank account. 
4. __makeChanges()__: A helper method that uses to determine if the information entered need additional changes; 
5. __endMessage(String accountType)__: A method that conclude the account opening application. 
6. __accountNumberGenerator()__: Generate a random number for the bank account number; 
7. __confirmInfo()__: A helper method that prints out the user input on the screen for confirmation; 
8. __updateInfo(String variable)__: A helper method that sets the updated information.
9. __initialDeposit()__: A help method that allows the user to set their initial deposit in their new bank account.



## Personal Account
Description: 
1. __getService()__: The open page that prompts the user to type in the service they want.
2. __deposit(double amount)__: A method for depositing money. Interface method.
3. __withdraw(double amount)__: A method for withdrawing money. Money withdrawals fails when the account balance is below the minimum daily balance. Interface method.
4. __getInterestRate()__: Interface method.
5. __getAccountBalance()__: Interface method.
6. __greeting()__: Print out the opening sentence that include the bank owner's first name, last name, and the account number. 
7. __setService(String service)__: Allows the program to categorize the user's input and run the subsequent program.
8. __moreService()__: A method that allows to check if the account owner want additional services provided in the option section.
9. __getCreditScore()__: A method to check the account owner's credit score. 
10. __getCreditStatus()__: A method that use the account owner's credit score as an input, and provides the credit status as an output. 
11. __getLoan(double loan)__: Based on the account owner's credit status, this method that print out the monthly payment for a loan that the account owner want. The monthly payment is calculated using the corresponding Annual Percent Rate.



## Business Account
Description: 
1. __getService()__: The open page that prompts the user to type in the service they want.
2. __deposit(double amount)__: A method for depositing money. Interface method.
3. __withdraw(double amount)__: A method for withdrawing money. Interface method.
4. __getInterestRate()__: Interface method.
5. __getAccountBalance()__: Interface method.
6. __setService(String service)__: Allows the program to categorize the user's input and run the subsequent program.
7. __moreService()__: A method that allows to check if the account owner want additional services provided in the option section.
8. __operatingExpense()__: Offer business owner to set up the percentage of the monthly revenue for operating expense such as rent and facilities. Another option to pay for the operating expense after the total amount of money is determined. 
9. __setOperatingExpense(float percent)__: A helper method for operatingExpense().
10. __payOperatingExpense()__: A helper method for operatingExpense().
11. __emergencyFunds()__: Save a percentage of the monthly revenue for emergency funds. The business owner can set the percentage, and is provided with the option to take out the emergency funds into the account balance. 
12. __setEmergencyFunds(float percent)__: A helper method for emergencyFunds().
13. __releaseEmergencyFunds()__: A helper method for emergencyFunds().
14. __payRolls()__: Determine the number of employees in the business and the employee income. The business owner can use this method to calculate the total amount of money for monthly employee payments, and is provided with the method to calculate the account balance after paying the employees.  
15. __setPayroll(int num, float amount)__: A helper method for payRolls().
16. __payEmployees()__: A helper method for payRolls().
17. __setSavingsGoal()__: Save a percentage of the monthly revenue for short-term and/or long-term goal such as buying new equipments and expanding business. 
18. __Taxes()__: Allows business owner to calculate the taxes based on the tax percentage and its monthly revenue. Also shows the account balance left after taxes.  
19. __setTaxes(float percentage)__: A helper method for Taxes().
20. __payTaxes()__: A helper method for Taxes().