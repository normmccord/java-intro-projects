// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord
public class Checking extends BankAccount {

    private double dailyWithdrawalLimit;

    // Overloaded constructor per spec
    public Checking(String name, String userId, String userPassword) {
        super(name, userId, userPassword);   // call parent overloaded constructor
        this.dailyWithdrawalLimit = 300.00;  // default per spec
    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }
}
