// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord

public class Health extends Insurance implements Deductible {

    // --- Attributes ---
    private double deductible;                 // amount of deductible
    private double totalDeductiblePaid = 0.0;  // initialized with 0
    private double copay;                      // amount of co-payment
    private double totalCopayPaid = 0.0;       // initialized with 0
    private double outOfPocketMax;             // total out-of-pocket amount

    // --- Constructor ---

    public Health(String policyholderFullName, double deductible, double copay, double outOfPocketMax) {
        super(policyholderFullName);
        this.deductible = deductible;
        this.copay = copay;
        this.outOfPocketMax = outOfPocketMax;
    }

    // --- Getters / Setters (for all attributes) ---
    public double getDeductible() {
        return deductible;
    }
    public void setDeductible(double deductible) {
        this.deductible = deductible;
    }

    public double getTotalDeductiblePaid() {
        return totalDeductiblePaid;
    }
    public void setTotalDeductiblePaid(double totalDeductiblePaid) {
        this.totalDeductiblePaid = totalDeductiblePaid;
    }

    public double getCopay() {
        return copay;
    }
    public void setCopay(double copay) {
        this.copay = copay;
    }

    public double getTotalCopayPaid() {
        return totalCopayPaid;
    }
    public void setTotalCopayPaid(double totalCopayPaid) {
        this.totalCopayPaid = totalCopayPaid;
    }

    public double getOutOfPocketMax() {
        return outOfPocketMax;
    }
    public void setOutOfPocketMax(double outOfPocketMax) {
        this.outOfPocketMax = outOfPocketMax;
    }

    @Override
    public void calculatePremium() {
        setPremium(deductible / 12.0);
    }

    @Override
    public boolean isDeductibleMet() {
        return totalDeductiblePaid >= deductible;
    }

    @Override
    public boolean isOutOfPocketMet() {
        return (totalDeductiblePaid + totalCopayPaid) >= outOfPocketMax;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                "%n[Health Policy]" +
                        "%nDeductible: %.2f" +
                        "%nTotal Deductible Paid: %.2f" +
                        "%nCo-Pay: %.2f" +
                        "%nTotal Co-Pay Paid: %.2f" +
                        "%nOut-of-Pocket Max: %.2f" +
                        "%nDeductible Met: %b" +
                        "%nOut-of-Pocket Met: %b",
                deductible, totalDeductiblePaid, copay, totalCopayPaid, outOfPocketMax,
                isDeductibleMet(), isOutOfPocketMet()
        );
    }

    public void addDeductiblePayment(double amount) {
        if (amount > 0) totalDeductiblePaid += amount;
    }
    public void addCopayPayment(double amount) {
        if (amount > 0) totalCopayPaid += amount;
    }
}