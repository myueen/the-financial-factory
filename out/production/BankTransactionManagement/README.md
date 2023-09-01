# BankManagement_Project

### Plan of Design:
This project creates a program using Java that mimics the functioning of a bank. Rather than simpling depositing and withdrawing money as an ATM, this program have the following additional benefits. First, the bank account opening is simulated by a subprogram named "Account Management". Two additional subprogram "Personal Account" and "Business Account" meets different needs for different bank account. In addition to depositing and withdrawing money, the personal account program offers users more options such as checking credit status and getting a loan. The business account offers an ever more diverse choices at managing the checking amount of a business. It allows account owner to allocate money for different purposes such as operating expenses, taxes, payrolls, and emergency funds. The business account program allows business owners to effectively subdivide the monthly revenue into different categories for management and payments.       

(1) OpenAccount
(2) Business bank account: (pay suppliers and employees, make purchases for your business, make business tax payments)
(3) Personal bank account: (deposit paycheck, pay household bills, make personal purchase. )
(4) BankAccount interface


## Account Management: 
Methods:
1. __getService()__: The open page that prompts the user to type in the service they want. 
2. __setService(String service)__: Allows the program to categorize the user's input and run the subsequent program.
3. __openAccount(String accountType)__: A method that prompts a series of questions that gathers information for the new bank account. 
4. __makeChanges()__: A helper method that uses to determine if the information entered need additional changes; 
5. __endMessage(String accountType)__: A method that conclude the account opening application. 
6. __accountNumberGenerator()__: Generate a random number for the bank account number; 
7. __confirmInfo()__: A helper method that prints out the user input on the screen for confirmation; 
8. __updateInfo(String variable)__: A helper method that sets the updated information.
9. __initialDeposit()__: A help method that allows the user to set their initial deposit in their new bank account.  



(1) Applicant Last Name:
(2) Applicant First Name:
(3) Date of Birth (Year, month, date):
(4) Contact (address):
(5) Email; 
(6) BankAccountNumber
(7) Initial Deposit;




## Personal a3.Bank Account
(1) deposit
(2) withdraw
(3) transaction history
(4) loan (annual percentage rate: interest rate charged per year for a loan or credit card)
    -credit status ==> average APR ==> Monthly Payment 
(5) Savings account
(6) Checking account
(7) Account balance
(8) Interest rate
(9) Minimum daily balance
(10) Transfer (the movement of funds from one account to another )
(11) Credit status: "Excellent", "Good", "Fair"




## Business a3.Bank Account
(1) Multiple checking account: 
    - (primary checking account: direct deposit and withdrawals;)
    - (operating expenses: cover monthly expenses - rent, software subscriptions, utility payments and travel expenses)
    - (emergency fund: save money in an account with a dedicated emergency fund for unexpected situations or expenses.
        = set aside a small percentage of your monthly revenue)
    - (payroll: one account for payroll and regularly fund it with necessary amount to cover a month worth of payroll)
    - (savings goals: short-term/long-term for down payment on a new piece of equipment or a new car.
        =allocate 5% of your revenue to set up automatic transfers)
    - (taxes: if your business brings in $10,000 a month, and you pay 15% in taxes, you'll want to store away %1500 a month in your tax account )