/**
 * This file illustrates the SOLID principles of Object-Oriented Programming (OOP) in Java.
 * Each principle is demonstrated with a simple example and explanation.
 */

public class SolidPrinciples {

    // 1. Single Responsibility Principle (SRP)
    // A class should have only one reason to change, meaning it should have only one job.
    static class Invoice {
        private double amount;

        public Invoice(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class InvoicePrinter {
        public void printInvoice(Invoice invoice) {
            System.out.println("Invoice amount: " + invoice.getAmount());
        }
    }

    // 2. Open/Closed Principle (OCP)
    // Software entities should be open for extension but closed for modification.
    interface Shape {
        double area();
    }

    static class Rectangle implements Shape {
        private double width, height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double area() {
            return width * height;
        }
    }

    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class AreaCalculator {
        public double totalArea(Shape[] shapes) {
            double total = 0;
            for (Shape shape : shapes) {
                total += shape.area();
            }
            return total;
        }
    }

    // 3. Liskov Substitution Principle (LSP)
    // Subtypes must be substitutable for their base types without altering the correctness of the program.
    static class Bird {
        public void fly() {
            System.out.println("Flying");
        }
    }

    static class Sparrow extends Bird {
        // Sparrow can fly, so no problem
    }

    static class Ostrich extends Bird {
        // Ostrich cannot fly, so overriding fly to throw exception violates LSP
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Ostrich can't fly");
        }
    }

    // Correct approach: separate flying behavior
    interface Flyable {
        void fly();
    }

    static class FlyingSparrow extends Bird implements Flyable {
        public void fly() {
            System.out.println("Flying");
        }
    }

    static class NonFlyingOstrich extends Bird {
        // No fly method here
    }

    // 4. Interface Segregation Principle (ISP)
    // Clients should not be forced to depend on interfaces they do not use.
    interface Workable {
        void work();
    }

    interface Feedable {
        void eat();
    }

    static class HumanWorker implements Workable, Feedable {
        public void work() {
            System.out.println("Working");
        }

        public void eat() {
            System.out.println("Eating");
        }
    }

    static class RobotWorker implements Workable {
        public void work() {
            System.out.println("Working");
        }
    }

    // 5. Dependency Inversion Principle (DIP)
    // High-level modules should not depend on low-level modules. Both should depend on abstractions.
    // Abstractions should not depend on details. Details should depend on abstractions.
    interface Keyboard {
        void type();
    }

    static class WiredKeyboard implements Keyboard {
        public void type() {
            System.out.println("Typing on wired keyboard");
        }
    }

    static class WirelessKeyboard implements Keyboard {
        public void type() {
            System.out.println("Typing on wireless keyboard");
        }
    }

    static class Computer {
        private Keyboard keyboard;

        public Computer(Keyboard keyboard) {
            this.keyboard = keyboard;
        }

        public void typeOnKeyboard() {
            keyboard.type();
        }
    }

    // Main method to demonstrate the principles
    public static void main(String[] args) {
        System.out.println("1. Single Responsibility Principle:");
        Invoice invoice = new Invoice(100);
        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(invoice);

        System.out.println("\n2. Open/Closed Principle:");
        Shape[] shapes = {new Rectangle(5, 10), new Circle(7)};
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Total area: " + calculator.totalArea(shapes));

        System.out.println("\n3. Liskov Substitution Principle:");
        Bird sparrow = new Sparrow();
        sparrow.fly();
        // Bird ostrich = new Ostrich();
        // ostrich.fly(); // This would throw exception, violating LSP

        Flyable flyingSparrow = new FlyingSparrow();
        flyingSparrow.fly();
        NonFlyingOstrich ostrich = new NonFlyingOstrich();
        System.out.println("Ostrich cannot fly, so no fly method called.");

        System.out.println("\n4. Interface Segregation Principle:");
        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();
        RobotWorker robot = new RobotWorker();
        robot.work();

        System.out.println("\n5. Dependency Inversion Principle:");
        Keyboard wired = new WiredKeyboard();
        Computer computer = new Computer(wired);
        computer.typeOnKeyboard();

        Keyboard wireless = new WirelessKeyboard();
        Computer laptop = new Computer(wireless);
        laptop.typeOnKeyboard();
    }
}
