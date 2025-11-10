// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord


import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountTest {

    // A static ArrayList to hold all bank accounts
    private static ArrayList<BankAccount> accounts = new ArrayList<>();


    // A static Scanner for user input, as recommended by the assignment hint
    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        boolean exit = false;

        // Main menu loop that continues until the user selects "6-Exit"
        while (!exit) {
            printMenu();

            String choice = input.nextLine();

            try {
                switch (choice) {
                    case "1":
                        createAccount();

                        break;
                    case "2":
                        deleteAccount();

                        break;
                    case "3":
                        makeDeposit();

                        break;
                    case "4":
                        makeWithdrawal();

                        break;
                    case "5":
                        checkBalance();

                        break;
                    case "6":
                        exit = true;

                        System.out.println("Thank you for using the bank. Exiting.");
                        break;
                    default:
                        System.out.println("Error: Please enter a valid choice (1 thru 6)");

                        break;
                }
            } catch (CustomerAccountNotFoundException | NegativeDollarAmountException | InsufficientFundsException | InvalidPasswordFormatException e) {
                System.out.println(e.toString());

            } catch (NumberFormatException e) {
                // Handles cases where user enters non-numeric text for a dollar amount
                System.out.println("Error: Invalid dollar amount. Please enter a numeric value.");
            }

            System.out.println();
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("1- Create An Account");

        System.out.println("2- Delete An Account");

        System.out.println("3- Make An Account Deposit");

        System.out.println("4- Make An Account Withdrawal");

        System.out.println("5- Check An Account Balance");

        System.out.println("6- Exit");

        System.out.println("Enter Choice: ");

    }

    private static void createAccount() throws InvalidPasswordFormatException {
        System.out.println("Enter Customer Name: ");

        String name = input.nextLine();
        System.out.println("Enter User ID: ");

        String userId = input.nextLine();
        System.out.println("Enter User Password: ");

        String password = input.nextLine();

        // The BankAccount/Checking constructors will validate the password format
        // and throw the exception if it's invalid.
        // The spec requires creating a Checking Account object.
        try {
            Checking newAccount = new Checking(name, userId, password);

            accounts.add(newAccount);

            System.out.println("Account successfully created for " + name);
        } catch (InvalidPasswordFormatException e) {
            System.out.println("Error: Must Enter a Valid Password");
            throw e;
        }
    }

    /**
     * Handles Menu Option 2: Delete an account.
     */
    private static void deleteAccount() throws CustomerAccountNotFoundException {
        System.out.print("Enter User ID: ");

        String userId = input.nextLine();
        System.out.print("Enter Password: ");

        String password = input.nextLine();

        // Find the account first
        BankAccount account = findAccount(userId, password);


        // If found, remove it from the list and decrease the static count
        accounts.remove(account);

        BankAccount.decreaseNumberOfAccounts();

        System.out.println("Account for " + account.getCustomerName() + " has been deleted.");
    }

    /**
     * Handles Menu Option 3: Make a deposit.
     */
    private static void makeDeposit() throws CustomerAccountNotFoundException, NegativeDollarAmountException {
        System.out.print("Enter User ID: ");

        String userId = input.nextLine();
        System.out.print("Enter Password: ");

        String password = input.nextLine();

        // Find the account
        BankAccount account = findAccount(userId, password);


        System.out.print("Enter Amount: ");

        double amount = Double.parseDouble(input.nextLine());

        // The deposit_amount method will handle the negative amount check
        try {
            account.deposit_amount(amount);

            System.out.println("Deposit successful. New balance: " + String.format("%.2f", account.getAccountBalance()));
        } catch (NegativeDollarAmountException e) {
            System.out.println("Error: Must Enter a Positive Dollar Amount");
            throw e;
        }
    }

    /**
     * Handles Menu Option 4: Make a withdrawal.
     */
    private static void makeWithdrawal() throws CustomerAccountNotFoundException, NegativeDollarAmountException, InsufficientFundsException {
        System.out.print("Enter User ID: ");

        String userId = input.nextLine();
        System.out.print("Enter Password: ");

        String password = input.nextLine();

        BankAccount account = findAccount(userId, password);


        System.out.print("Enter Amount: ");

        double amount = Double.parseDouble(input.nextLine());

        // The withdraw_amount method handles both checks
        try {
            account.withdraw_amount(amount);

            System.out.println("Withdrawal successful. New balance: " + String.format("%.2f", account.getAccountBalance()));
        } catch (NegativeDollarAmountException e) {
            System.out.println("Error: Must Enter a Positive Dollar Amount");
            throw e;
        } catch (InsufficientFundsException e) {
            System.out.println("Error: Must Withdrawal an Amount Less Than Your Balance");
            throw e;
        }
    }

    /**
     * Handles Menu Option 5: Check account balance.
     */
    private static void checkBalance() throws CustomerAccountNotFoundException {
        System.out.print("Enter User ID: ");

        String userId = input.nextLine();
        System.out.print("Enter Password: ");

        String password = input.nextLine();

        // Find the account
        BankAccount account = findAccount(userId, password);


        // Print general account info
        System.out.println("Customer Name: " + account.getCustomerName());

        System.out.println("Account Number: " + account.getAccountNumber());

        System.out.println("Account Balance: " + String.format("%.1f", account.getAccountBalance()));


        // Check if the account is a Checking account using polymorphism
        if (account instanceof Checking) {

            // Cast the object to access Checking-specific methods
            Checking checkingAccount = (Checking) account;

            System.out.println("Account Type: Checking");

            System.out.println("Account Daily Withdrawal Limit: " + String.format("%.1f", checkingAccount.getDailyWithdrawalLimit()));

        }
    }

    /**
     * Helper method to search the ArrayList for an account.
     * Used by delete, deposit, withdrawal, and balance check.
     */
    private static BankAccount findAccount(String userId, String password) throws CustomerAccountNotFoundException {
        for (BankAccount acc : accounts) {
            if (acc.getUserId().equals(userId) && acc.getUserPassword().equals(password)) {
                return acc;

            }
        }
        // If no account is found after the loop, throw the exception
        System.out.println("Error: Must Enter a Valid User ID and Password");
        throw new CustomerAccountNotFoundException("Customer Account Not Found");

    }
}