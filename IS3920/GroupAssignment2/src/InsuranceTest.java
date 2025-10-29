// Contributors are Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Driver class for the insurance policy system.
 */
public class InsuranceTest {

    public static void main(String[] args) {

        // Create the list to hold all policy objects
        ArrayList<Insurance> policies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        // Main menu loop
        while (keepRunning) {
            System.out.println("1 - Create Health Insurance Policy"); //
            System.out.println("2 - Create Term-Life Insurance Policy");
            System.out.println("3 - Exit"); // [cite: 116]
            System.out.println(); // print blank line to separate options from user prompt
            System.out.print("Enter Choice: "); // [cite: 117]

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); //

                switch (choice) {
                    case 1:
                        // Create Health Insurance Policy
                        System.out.print("Enter name of policy holder: ");
                        String holder = scanner.nextLine();

                        System.out.print("Enter deductible amount: ");
                        double deductible = scanner.nextDouble();

                        System.out.print("Enter co-payment: ");
                        double copay = scanner.nextDouble();

                        System.out.print("Enter total out-of-pocket amount: ");
                        double oop = scanner.nextDouble();

                        scanner.nextLine();

                        policies.add(new Health(holder, deductible, copay, oop));
                        System.out.println("Health policy created.");
                        break;

                    case 2:
                        // Create Term-Life Insurance Policy
                        System.out.print("Enter name of policy holder: ");
                        String holderTerm = scanner.nextLine();

                        System.out.print("Enter name of beneficiary: ");
                        String beneficiary = scanner.nextLine();

                        System.out.print("Enter number of years in term: ");
                        int term = scanner.nextInt();

                        System.out.print("Enter amount of payout: ");
                        double payout = scanner.nextDouble();

                        scanner.nextLine();

                        policies.add(new TermLife(holderTerm, beneficiary, term, payout));
                        System.out.println("Term-Life policy created.");
                        break;

                    case 3:
                        keepRunning = false;
                        break;

                    default:
                        System.out.println("Error: Please enter valid input");
                        break;
                }
            } else {
                System.out.println("Error: Please enter valid input");
                scanner.next();
            }

            System.out.println();
        }

        // --- Loop has ended, print the report ] ---
        System.out.println("---------------------------------");
        System.out.println("Insurance Policy Report");
        System.out.println("---------------------------------");

        // Go over entire list
        for (Insurance policy : policies) {

            // Calculate the premium for each object
            policy.calculatePremium();

            // Print common details
            System.out.println("Policyholder: " + policy.getPolicyholderFullName());
            System.out.println("Policy Number: " + policy.getPolicyNumber());

            // Print premium formatted to two decimal points
            System.out.printf("Premium: $%.2f%n", policy.getPremium());

            // Check if the object is a Health
            if (policy instanceof Health) {
                Health healthPolicy = (Health) policy;

                // Print health-specific details
                System.out.println("Met Deductible: " + healthPolicy.isDeductibleMet());
                System.out.println("Met Total Out-Of-Pocket: " + healthPolicy.isOutOfPocketMet());
            }
            System.out.println(); //
        }

        scanner.close();
    }
}