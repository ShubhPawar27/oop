public // Abstract Base Class Shape
abstract class hape {
    // Two double type values for dimensions
    protected double dimension1;
    protected double dimension2;

    // Method to input dimensions (in this case, length and height or length and width)
    public void inputDimensions(double dimension1, double dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    // Abstract method to compute area
    public abstract double computeArea();
}

// Derived Class: Triangle
class Triangle extends hape {
    // Override computeArea() for Triangle
    @Override
    public double computeArea() {
        // Formula for area of triangle: 1/2 * base * height
        return 0.5 * dimension1 * dimension2;
    }
}


// Derived Class: Rectangle
class Rectangle extends hape {
    // Override computeArea() for Rectangle
    @Override
    public double computeArea() {
        // Formula for area of rectangle: length * width
        return dimension1 * dimension2;
    }
}

// Main class to test the functionality
public class Shape {
    public static void main(String[] args) {
        // Creating a shape reference to hold different shapes
        hape shape;

        // Creating a Triangle object and inputting its dimensions
        shape = new Triangle();
        shape.inputDimensions(5.0, 10.0);  // Base = 5.0, Height = 10.0
        System.out.println("Area of Triangle: " + shape.computeArea());

        // Creating a Rectangle object and inputting its dimensions
        shape = new Rectangle();
        shape.inputDimensions(4.0, 6.0);  // Length = 4.0, Width = 6.0
        System.out.println("Area of Rectangle: " + shape.computeArea());
    }
}
