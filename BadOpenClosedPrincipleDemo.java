// Example of a violation of the Open/Closed Principle (OCP)
// In this design, every time you add a new shape, you must modify BadAreaCalculator.
// This is BAD because the class is not closed for modification.

class BadAreaCalculator {
    // This method checks the type of each shape and calculates area accordingly.
    // If you add a new shape, you must add another 'if' or 'else if' block here.
    // This means you are constantly modifying this method, which violates OCP.
    public double totalArea(Object[] shapes) {
        double total = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                total += r.getWidth() * r.getHeight();
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                total += Math.PI * c.getRadius() * c.getRadius();
            }
            // BAD: To add a new shape, you must modify this method, violating OCP.
        }
        return total;
    }
}

// Rectangle class represents a rectangle shape.
class Rectangle {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

// Circle class represents a circle shape.
class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() { return radius; }
}

// Main class to demonstrate the violation of OCP.
public class BadOpenClosedPrincipleDemo {
    public static void main(String[] args) {
        // We create an array of shapes (Rectangles and Circles)
        Object[] shapes = { new Rectangle(3, 4), new Circle(5) };
        BadAreaCalculator calculator = new BadAreaCalculator();
        // The totalArea method will work, but if we add a new shape, we must edit BadAreaCalculator
        System.out.println("Total area: " + calculator.totalArea(shapes));
    }
}

// SUMMARY:
// - This code violates OCP because adding a new shape requires editing BadAreaCalculator.
// - Good OCP design would allow adding new shapes without modifying the area calculation logic.
