// Interface for insurance policies with deductibles
public interface Deductible {

    // Checks if the deductible has been met
    boolean isDeductibleMet();

    // Checks if the total out-of-pocket amount has been met
    boolean isOutOfPocketMet();
}
