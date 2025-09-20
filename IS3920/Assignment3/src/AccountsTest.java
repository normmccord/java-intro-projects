/*
Norman McCord
Kennesaw State University
IS3920
Assignment 3
Control Statements
 */

import java.util.Scanner;

public class AccountsTest {

    // Menu display
    public static void TransactionMenu() {
        System.out.println("************************");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Check Balance");
        System.out.println("4) Exit");
        System.out.println("************************");
        System.out.print("Enter option: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create an account with your name
        Accounts acct = new Accounts("Norm McCord");

        boolean running = true;
        while (running) {
            TransactionMenu();

            // accept only 1-4, give an error for any other input, go back to menu
            int choice;
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 4) {
                        break;
                    }
                    else {
                        System.out.print("Error: must enter a 1, 2, 3, or 4. Please try again: ");
                    }
                }
                else {
                    sc.next();
                    System.out.print("Error: must enter a 1, 2, 3, or 4. Please try again: ");
                }
            }

            // menu switches
            switch (choice) {
                case 1: //deposit
                    System.out.print("enter a deposit amount: ");
                    double dep = readPositiveDouble(sc);
                    acct.addAmount(dep);
                    acct.displayBalance();
                    System.out.println("Transaction Complete.");
                    System.out.println();
                    break;

                case 2: //withdrawal
                    System.out.print("Enter a withdrawal amount: ");
                    double wd = readPositiveDouble(sc);
                    acct.deductAmount(wd);
                    acct.displayBalance();
                    System.out.println("Transaction Complete.");
                    break;

                case 3: //check balance
                    acct.displayBalance();
                    System.out.println("Tranaction Complete.");
                    System.out.println();
                    break;

                case 4: // Exit
                    running = false;
                    System.out.println("Goodbye.");
                    break;
            }
        }

        sc.close();

    }

    // reads for a negative input and prompts again
    private static double readPositiveDouble(Scanner sc) {
        while (true) {
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                if (val >= 0.0) {
                    return val;
                } else {
                    System.out.print("Amount must be nonnegative. Try again: ");
                }
            }
            else {
                sc.next();
                System.out.print("Enter a valid number: ");
            }
        }
    }
}

