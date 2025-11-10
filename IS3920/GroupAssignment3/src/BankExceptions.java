// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord

// Thrown when a password is not at least 8 chars or lacks an asterisk '*'.
class InvalidPasswordFormatException extends Exception {
    public InvalidPasswordFormatException() {
        super("Invalid password format: must be ≥ 8 characters and include at least one '*'.");
    }
    public InvalidPasswordFormatException(String message) {
        super(message);
    }
    public InvalidPasswordFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidPasswordFormatException(Throwable cause) {
        super(cause);
    }
}

// Thrown when a negative (or zero, if you choose) dollar amount is provided where a positive amount is required.
class NegativeDollarAmountException extends Exception {
    public NegativeDollarAmountException() {
        super("Dollar amount must be positive.");
    }
    public NegativeDollarAmountException(String message) {
        super(message);
    }
    public NegativeDollarAmountException(String message, Throwable cause) {
        super(message, cause);
    }
    public NegativeDollarAmountException(Throwable cause) {
        super(cause);
    }
}

// Thrown when a withdrawal exceeds the available balance.
class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds for this transaction.");
    }
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    public InsufficientFundsException(Throwable cause) {
        super(cause);
    }
}

// Thrown when no account matches the provided user id + password during lookup.
class CustomerAccountNotFoundException extends Exception {
    public CustomerAccountNotFoundException() {
        super("Customer account not found for the provided credentials.");
    }
    public CustomerAccountNotFoundException(String message) {
        super(message);
    }
    public CustomerAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerAccountNotFoundException(Throwable cause) {
        super(cause);
    }
}