// Single Responsibility Principle (SRP):
// A class should have only one reason to change, meaning it should have only one job or responsibility.
// This makes code easier to maintain, test, and understand.
//
// The example below violates SRP because it combines student and report generation and file saving in one class.

public class BadStudentReport {
    private String name;
    private int marks;

    public BadStudentReport(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String generateReport() {
        return "Student: " + name + ", Marks: " + marks;
    }

    public void saveToFile(String report) {
        // Simulate saving to a file
        System.out.println("Saving report: " + report);
    }
    
}
