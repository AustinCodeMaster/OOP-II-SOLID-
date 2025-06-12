// Open/Closed Principle (OCP):
// Software entities (classes, modules, functions) should be open for extension, but closed for modification.
// This means you should be able to add new functionality without changing existing code.
//
// Example:
// Suppose we have a class that calculates the area of different shapes.
// A bad design would require modifying the class every time a new shape is added.
//
// Good OCP design uses inheritance or interfaces to allow extension without modification.

// Shape interface
interface Shape {
    double area();
}

// Rectangle class implements Shape
class Rectangle implements Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double area() {
        return width * height;
    }
}

// Circle class implements Shape
class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
}

// AreaCalculator uses the Shape interface, so it is closed for modification but open for extension
class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.area();
        }
        return total;
    }
}

// Main class to demonstrate OCP
public class OpenClosedPrincipleDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Rectangle(3, 4), new Circle(5) };
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total area: " + calculator.totalArea(shapes));
    }
}

// To add a new shape, just create a new class implementing Shape. No need to modify AreaCalculator.
