import java.io.PrintStream;
import java.util.Scanner;

public class Assignment1Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int num3;
        int sum;

        System.out.print("Enter 1st integer: ");
        num1 = input.nextInt();

        System.out.print("Enter 2nd integer: ");
        num2 = input.nextInt();

        System.out.print("Enter 3rd integer: ");
        num3 = input.nextInt();

        sum = num1 + num2 + num3;

        System.out.printf("Sum is %d\n", sum);


    }
}
