public class Rectangle {
    // Private attributes
    private int width;
    private int height;

    // Overloaded constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Getter and Setter for width
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // Getter and Setter for height
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Method to calculate perimeter
    public int perimeter() {
        return 2 * width + 2 * height;
    }

    // Method to calculate area
    public int area() {
        return width * height;
    }
}
