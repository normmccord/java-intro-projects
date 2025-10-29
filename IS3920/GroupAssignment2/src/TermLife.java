// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord

// TermLife.java
// Subclass representing a term-life insurance policy

public class TermLife extends Insurance {

    // --- Term-life specific attributes ---
    private String beneficiaryFullName;
    private int policyTerm;          // in years
    private double termPayout;       // total payout amount

    // --- Constructor ---
    public TermLife(String policyholderFullName, String beneficiaryFullName, int policyTerm, double termPayout) {
        super(policyholderFullName);             // set policyholder and assign unique policy number
        this.beneficiaryFullName = beneficiaryFullName;
        this.policyTerm = policyTerm;
        this.termPayout = termPayout;
    }

    // --- Getters / Setters ---
    public String getBeneficiaryFullName() {
        return beneficiaryFullName;
    }

    public void setBeneficiaryFullName(String beneficiaryFullName) {
        this.beneficiaryFullName = beneficiaryFullName;
    }

    public int getPolicyTerm() {
        return policyTerm;
    }

    public void setPolicyTerm(int policyTerm) {
        this.policyTerm = policyTerm;
    }

    public double getTermPayout() {
        return termPayout;
    }

    public void setTermPayout(double termPayout) {
        this.termPayout = termPayout;
    }

    // --- Required override: calculates the premium (no params, no return) ---
    // Premium = term payout / (12 * term in years)
    @Override
    public void calculatePremium() {
        if (policyTerm <= 0) {
            // Avoid division by zero; treat as zero premium if term is invalid
            setPremium(0.0);
        } else {
            double monthly = termPayout / (12.0 * policyTerm);
            setPremium(monthly);
        }
    }

    // --- Override toString to include labels and values for all attributes ---
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // include all inherited fields via super.toString()
        sb.append(super.toString());
        // append subclass-specific fields
        sb.append("\nBeneficiary Full Name: ").append(beneficiaryFullName);
        sb.append("\nPolicy Term (years): ").append(policyTerm);
        sb.append("\nTerm Payout: ").append(String.format("%.2f", termPayout));
        return sb.toString();
    }

    //test main
//    public static void main(String[] args) {
//        TermLife p = new TermLife("Alice Holder", "Bob Beneficiary", 20, 250_000);
//        p.calculatePremium();
//        System.out.println(p);
//    }
}
