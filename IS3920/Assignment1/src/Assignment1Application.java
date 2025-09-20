import java.util.Scanner;
import java.util.Arrays;

public class Assignment1Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int num3;
        int sum;

        //get 3 integers from the user
        System.out.print("Enter 1st integer: ");
        num1 = input.nextInt();

        System.out.print("Enter 2nd integer: ");
        num2 = input.nextInt();

        System.out.print("Enter 3rd integer: ");
        num3 = input.nextInt();

        //Display avg of the 3 integers if the first is even, otherwise show the product; avg should be a double and calculation formula should use casting
        if (num1 % 2 == 0) {
            double average = ((double) num1 + num2 + num3) / 3.0;
            System.out.printf("Average of the three integers: %.2f%n", average);
        } else {
            long product = (long) num1 * num2 * num3;
            System.out.println("Product of the three integers: " + product);
        }

        //Display the smallest and largest of the 3 integers
        int largest = Math.max(num1, Math.max(num2, num3));
        int smallest = Math.min(num1, Math.min(num2, num3));
        System.out.println("The largest integer is: " + largest);
        System.out.println("The smallest integer is: " + smallest);

        //Display the 3 numbers in descending order
        int[] numList = {num1, num2, num3};
        Arrays.sort(numList);
        System.out.println("Numbers in descending order: " + numList[2] + ", " + numList[1] + ", " + numList[0]);

    }
}
