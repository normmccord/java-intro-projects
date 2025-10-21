// Abstract class for all insurance policies
public abstract class insurance {

    // Instance variables
    private String policyholderFullName;
    private int policyNumber;
    private static int totalPolicies = 0;
    private double premium = 0.0;

    // Constructor assigns name and unique policy number
    public insurance(String policyholderFullName) {
        this.policyholderFullName = policyholderFullName;
        this.policyNumber = totalPolicies; // start at 0
        totalPolicies++;
    }

    // Getters and setters
    public String getPolicyholderFullName() {
        return policyholderFullName;
    }

    public void setPolicyholderFullName(String policyholderFullName) {
        this.policyholderFullName = policyholderFullName;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public static int getTotalPolicies() {
        return totalPolicies;
    }

    public static void setTotalPolicies(int totalPolicies) {
        insurance.totalPolicies = totalPolicies;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    // Abstract method to be defined in subclasses
    public abstract void calculatePremium();

    // Returns a summary of policy information
    @Override
    public String toString() {
        return "Policyholder: " + policyholderFullName + "\n" +
               "Policy Number: " + policyNumber + "\n" +
               "Total Policies Created: " + totalPolicies + "\n" +
               String.format("Premium: %.2f", premium);
    }
}
