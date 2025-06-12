// GoodStudentReport class follows the Single Responsibility Principle (SRP):
// - It only stores student data and generates a report .
// - It does NOT handle saving or displaying the report.
// - If you want to change how the report is generated, you only modify this class.

public class GoodStudentReport {
    private String name;
    private int marks;

    public GoodStudentReport(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String generateReport() {
        return "Student: " + name + ", Marks: " + marks;
    }
}

