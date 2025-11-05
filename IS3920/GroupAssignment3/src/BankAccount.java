// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord
// BankAccount.java - Base class for all bank accounts
public class BankAccount {

    private String customerName;
    private int accountNumber;
    private static int numberOfAccounts = 0;
    private String userId;
    private String userPassword;
    private double accountBalance;

    // Constructor
    public BankAccount(String name, String id, String password)
            throws InvalidPasswordFormatException {
        validatePassword(password);
        this.customerName = name;
        this.userId = id;
        this.userPassword = password;
        numberOfAccounts++;
        this.accountNumber = numberOfAccounts;
        this.accountBalance = 0.0;
    }

    // Getters and setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String name) { this.customerName = name; }

    public String getUserId() { return userId; }
    public void setUserId(String id) { this.userId = id; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String password) throws InvalidPasswordFormatException {
        validatePassword(password);
        this.userPassword = password;
    }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(double balance) { this.accountBalance = balance; }

    public int getAccountNumber() { return accountNumber; }

    public static int getNumberOfAccounts() { return numberOfAccounts; }

    // Decrease static count by one
    public static void decreaseNumberOfAccounts() {
        if (numberOfAccounts > 0) {
            numberOfAccounts--;
        }
    }

    // Deposit method
    public void deposit_amount(double amount) throws NegativeDollarAmountException {
        if (amount <= 0) {
            throw new NegativeDollarAmountException("Negative Dollar Amount");
        }
        accountBalance += amount;
    }

    // Withdraw method
    public void withdraw_amount(double amount)
            throws NegativeDollarAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new NegativeDollarAmountException("Negative Dollar Amount");
        }
        if (amount > accountBalance) {
            throw new InsufficientFundsException("Insufficient Funds");
        }
        accountBalance -= amount;
    }

    // Validate password rules
    public static void validatePassword(String pw) throws InvalidPasswordFormatException {
        if (pw == null || pw.length() < 8 || pw.indexOf('*') < 0) {
            throw new InvalidPasswordFormatException("Invalid Password Format");
        }
    }

    // Print account info
    @Override
    public String toString() {
        return "Customer Name: " + customerName +
               ", Account Number: " + accountNumber +
               String.format(", Balance: %.2f", accountBalance);
    }
}
