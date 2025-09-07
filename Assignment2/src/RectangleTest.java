import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Prompt for width
        System.out.print("Enter rectangle width: ");
        int width = input.nextInt();

        // Step 2: Prompt for height
        System.out.print("Enter rectangle height: ");
        int height = input.nextInt();

        // Step 3: Create rectangle object
        Rectangle rectangle_1 = new Rectangle(width, height);

        // Step 4: Display initial values
        System.out.println("\nInitial Rectangle:");
        System.out.println("Width: " + rectangle_1.getWidth());
        System.out.println("Height: " + rectangle_1.getHeight());
        System.out.println("Area: " + rectangle_1.area());
        System.out.println("Perimeter: " + rectangle_1.perimeter());

        // Step 5: Double the width and height using getters and setters only
        rectangle_1.setWidth(rectangle_1.getWidth() * 2);
        rectangle_1.setHeight(rectangle_1.getHeight() * 2);

        // Step 6: Display updated values
        System.out.println("\nUpdated Rectangle (doubled size):");
        System.out.println("Width: " + rectangle_1.getWidth());
        System.out.println("Height: " + rectangle_1.getHeight());
        System.out.println("Area: " + rectangle_1.area());
        System.out.println("Perimeter: " + rectangle_1.perimeter());

        input.close();
    }
}
