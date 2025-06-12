public class Main {
    public static void main(String[] args) {
        // Using the good SRP version
        GoodStudentReport report = new GoodStudentReport("Austin", 95);
        String content = report.generateReport();

        ReportSaver saver = new ReportSaver();
        saver.saveToFile(content);
    }
}

// Main class demonstrates SRP by using separate classes for each responsibility:
// - GoodStudentReport: handles student data and report generation.
// - ReportSaver: handles saving the report to a file.
// - Main: coordinates the process, but does not mix responsibilities.

